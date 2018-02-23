package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.controllers.responses.data.*;
import me.hitit.api.domains.User;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.encript.Encriptor;
import me.hitit.api.utils.res.Strings;
import me.hitit.api.view_objects.GetUserViewObject;
import me.hitit.api.view_objects.SignUpViewObject;
import me.hitit.api.view_objects.UpdateUserViewObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("")
@Api
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());

	@Autowired
	private UserService us;

	@GetMapping("user/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getUser(@RequestHeader("Authorization") String jwt,
			@PathVariable("uidx") final Long uidx) {
		GetUserViewObject guvo= GetUserViewObject.getCreate(us.getUser(uidx));
		GetUserResponseData gurd= GetUserResponseData.ofCreate(guvo);
		DefaultResponse dr = new DefaultResponse(gurd.getStatus(),gurd,gurd.getMsg());
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	@GetMapping("users")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getUsers(@RequestHeader("Authorization") String jwt,
			@RequestParam("page") Long page, @RequestParam("sort") String sort) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}


	@GetMapping("user/check/email/{email:.+}")
	public @ResponseBody ResponseEntity<DefaultResponse> checkEmail(@PathVariable("email") final String email) {
		Boolean exist = us.isEmailExist(email);
		CheckEmailResponseData cerd = CheckEmailResponseData.ofCreate(exist);
		DefaultResponse dr = new DefaultResponse(cerd.getStatus(),cerd,cerd.getMsg());
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	@GetMapping("user/check/phoneNumber/{phoneNumber}")
	public @ResponseBody ResponseEntity<DefaultResponse> checkPhoneNumber(
			@PathVariable("phoneNumber") final String phoneNumber) {
		Boolean exist = us.isPhoneNumberExist(phoneNumber);
		CheckPhoneNumberResponseData cpnrd = CheckPhoneNumberResponseData.ofCreat(exist);
		DefaultResponse dr = new DefaultResponse(cpnrd.getStatus(),cpnrd,cpnrd.getMsg());
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	@PostMapping("user/sign/up")
	public @ResponseBody ResponseEntity<DefaultResponse> signUp(@Valid @RequestBody final SignUpForm suf)
			throws NoSuchAlgorithmException {
		// Use password encryption method done
		SignUpViewObject suvo= us.addUser(suf);
		DefaultResponse dr = new DefaultResponse(suvo.getStatus(),suvo,suvo.getMsg());
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	@PostMapping("user/sign/in")
	public @ResponseBody ResponseEntity<DefaultResponse> signIn(@Valid @RequestBody final SignInForm sif)
			throws NoSuchAlgorithmException {
        GetUserViewObject guvo = us.getUser(sif.getEmail(), Encriptor.sha256(sif.getPassword()));
		SignInResponseData sird = SignInResponseData.ofCreate(guvo);
		DefaultResponse dr = new DefaultResponse(sird.getStatus(),sird,sird.getMsg());
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	@PutMapping("user/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> updateUserPassword(
			@Valid @RequestHeader("Authorization") String jwt, @PathVariable("uidx") final Long uidx,
			@RequestBody final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
		UpdateUserViewObject uuvo = us.updateUser(uidx,uupf);
		UpdateUserReponseData uurd = UpdateUserReponseData.ofCreate(uuvo);
		DefaultResponse dr = new DefaultResponse(uurd.getStatus(),uurd,uurd.getMsg());
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	@ExceptionHandler(NoSuchAlgorithmException.class)
	public ResponseEntity<?> handleStorageFileNotFound(NoSuchAlgorithmException nsae) {
		DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ALGORITHM);
		return new ResponseEntity<>(dr, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}