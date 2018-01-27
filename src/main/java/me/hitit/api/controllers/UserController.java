package me.hitit.api.controllers;

import org.apache.log4j.Logger;
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
import me.hitit.api.utils.auth.Auth;

@RestController
@RequestMapping("")
@Api
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());

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
			@RequestParam("page") long page, @RequestParam("sort") String sort) {
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
		// TODO : Use password encryption method.
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