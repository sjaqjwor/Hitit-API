package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import me.hitit.api.domains.User;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
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
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
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
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("user/check/phoneNumber/{phoneNumber}")
	public @ResponseBody ResponseEntity<DefaultResponse> checkPhoneNumber(
			@PathVariable("phoneNumber") final String phoneNumber) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("user/sign/up")
	public @ResponseBody ResponseEntity<DefaultResponse> signUp(@RequestBody final SignUpForm suf) {
		// Use password encryption method done
		if(us.isPhoneNumberExist(suf.getPhoneNumber())) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL,Strings.ALREADY_EXIST_PHONE_NUMBER);
			return new ResponseEntity<>(dr,HttpStatus.UNAUTHORIZED);
		}
		if(us.isEmailExist(suf.getEmail())) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL,Strings.ALREADY_EXIST_EMAIL);
			return new ResponseEntity<>(dr,HttpStatus.UNAUTHORIZED);
		}
		User u = new User();
		u.setEmail(suf.getEmail());
		u.setName(suf.getName());
		u.setPhoneNumber(suf.getPhoneNumber());
		u.setPassword(Encriptor.generateEncript(suf.getPassword()));
		us.addUser(u);
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("user/sign/in")
	public @ResponseBody ResponseEntity<DefaultResponse> signIn(@RequestBody final SignInForm sif) {
		// TODO : Use password encryption method.
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("user/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> updateUserPassword(@RequestHeader("Authorization") String jwt,
			@PathVariable("uidx") final Long uidx, final UpdateUserPasswordForm uupf) {
		// TODO : Use password encryption method.
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}