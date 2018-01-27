package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.CheckEmailForm;
import me.hitit.api.controllers.forms.CheckPhoneNumberForm;
import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;

@RestController
@RequestMapping("")
@Api
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());

	@GetMapping("user/{idx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getUser(@RequestHeader("Authorization") String jwt) {
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

	@GetMapping("user/check/email")
	public @ResponseBody ResponseEntity<DefaultResponse> checkEmail(@RequestBody final CheckEmailForm cef) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("user/check/phoneNumber")
	public @ResponseBody ResponseEntity<DefaultResponse> checkPhoneNumber(
			@RequestBody final CheckPhoneNumberForm cpnf) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("user/sign/up")
	public @ResponseBody ResponseEntity<DefaultResponse> signUp(@RequestBody final SignUpForm suf) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("user/sign/in")
	public @ResponseBody ResponseEntity<DefaultResponse> signIn(@RequestBody final SignInForm sif) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("user/{idx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> putUser(@RequestHeader("Authorization") String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}