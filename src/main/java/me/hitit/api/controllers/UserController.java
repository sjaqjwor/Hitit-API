package me.hitit.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.controllers.responses.data.CheckEmailResponseData;
import me.hitit.api.controllers.responses.data.GetUserResponseData;
import me.hitit.api.controllers.responses.data.SignInResponseData;
import me.hitit.api.domains.User;
import me.hitit.api.dtos.UserDto;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.auth.JWT;
import me.hitit.api.utils.encript.Encriptor;
import me.hitit.api.utils.res.Strings;

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
		User u = us.getUser(uidx);
		if (u == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<>(dr, HttpStatus.NOT_FOUND);
		} else {
			GetUserResponseData ogurd = new GetUserResponseData(UserDto.getUserDto(u));
			DefaultResponse dr = new DefaultResponse(ogurd);
			return new ResponseEntity<>(dr, HttpStatus.OK);
		}
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
		Boolean exist = us.getUserByEmail(email);
		CheckEmailResponseData cuird = new CheckEmailResponseData(exist);
		if (exist == true) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, cuird, Strings.ALREADY_EXIST_EMAIL);
			return new ResponseEntity<>(dr, HttpStatus.CONFLICT);
		} else {
			DefaultResponse dr = new DefaultResponse(cuird);
			return new ResponseEntity<>(dr, HttpStatus.OK);
		}
	}

	@GetMapping("user/check/phoneNumber/{phoneNumber}")
	public @ResponseBody ResponseEntity<DefaultResponse> checkPhoneNumber(
			@PathVariable("phoneNumber") final String phoneNumber) {
		Boolean exist = us.getUserByPhoneNumber(phoneNumber);
		CheckEmailResponseData cuird = new CheckEmailResponseData(exist);
		if (exist == true) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, cuird, Strings.ALREADY_EXIST_PHONE_NUMBER);
			return new ResponseEntity<>(dr, HttpStatus.CONFLICT);
		} else {
			DefaultResponse dr = new DefaultResponse(cuird);
			return new ResponseEntity<>(dr, HttpStatus.OK);
		}
	}

	@PostMapping("user/sign/up")
	public @ResponseBody ResponseEntity<DefaultResponse> signUp(@Valid @RequestBody final SignUpForm suf)
			throws NoSuchAlgorithmException {
		// Use password encryption method done
		Map<Integer, Object> map = us.addUser(suf);
		if (map.containsKey(1)) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, (String) map.get(1));
			return new ResponseEntity<>(dr, HttpStatus.CONFLICT);
		} else {
			DefaultResponse dr = new DefaultResponse();
			return new ResponseEntity<>(dr, HttpStatus.OK);
		}
	}

	@PostMapping("user/sign/in")
	public @ResponseBody ResponseEntity<DefaultResponse> signIn(@Valid @RequestBody final SignInForm sif)
			throws NoSuchAlgorithmException {
		// TODO : Use password encryption method.
		UserDto ud = us.getUser(sif.getEmail(), Encriptor.sha256(sif.getPassword()));
		if (ud == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, new SignInResponseData(), Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<>(dr, HttpStatus.NOT_FOUND);
		} else {
			DefaultResponse dr = new DefaultResponse(new SignInResponseData(JWT.create(ud.getIdx()), ud));
			return new ResponseEntity<>(dr, HttpStatus.OK);
		}
	}

	@PutMapping("user/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> updateUserPassword(
			@Valid @RequestHeader("Authorization") String jwt, @PathVariable("uidx") final Long uidx,
			@RequestBody final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
		// Use password encryption method.
		UserDto ud = us.updateUser(uidx, uupf);
		if (ud == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<>(dr, HttpStatus.NOT_FOUND);
		} else {
			DefaultResponse dr = new DefaultResponse(ud);
			return new ResponseEntity<>(dr, HttpStatus.OK);
		}
	}

	@ExceptionHandler(NoSuchAlgorithmException.class)
	public ResponseEntity<?> handleStorageFileNotFound(NoSuchAlgorithmException nsae) {
		DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ALGORITHM);
		return new ResponseEntity<>(dr, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}