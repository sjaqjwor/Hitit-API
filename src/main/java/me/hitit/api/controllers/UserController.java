package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.controllers.responses.data.GetUserResponseData;
import me.hitit.api.controllers.responses.data.SignInResponseData;
import me.hitit.api.domains.User;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.auth.JWT;
import me.hitit.api.utils.log.ControllerLog;
import me.hitit.api.utils.res.Strings;
import springfox.documentation.annotations.ApiIgnore;

/**
 * UserController class.
 *
 * @author devetude, cheoljin_k
 */
@RestController
@RequestMapping("user")
@Api
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());

	@Autowired
	private UserService us;

	/**
	 * Methods to sign in and return token.
	 *
	 * @param sif
	 * @return
	 */
	@PostMapping("/sign/in")
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> signIn(@RequestBody final SignInForm sif) {
		User u = us.getUser(sif.getEmail(), sif.getPassword());

		if (u == null) {
			LOG.warn(Strings.CAN_NOT_FOUND_USER);

			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<>(dr, HttpStatus.UNAUTHORIZED);
		}

		String jwt = JWT.create(u.getIdx());

		if (jwt == null) {
			LOG.error(Strings.FAIL_TO_CREATE_TOKEN);

			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.FAIL_TO_CREATE_TOKEN);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DefaultResponse dr = new DefaultResponse(new SignInResponseData(jwt));
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to get a user.
	 *
	 * @param jwt
	 * @param u
	 * @param idx
	 * @return
	 */
	@GetMapping("/{idx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getUser(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @PathVariable("idx") final long idx) {
		User findUser = us.getUser(idx);
		System.out.println("dddddddddddddddddddddddddddddd"+findUser.getDevice().getIdx());
		LOG.debug("sssssssssssssssssssssss"+findUser.getDevice().getIdx());
		DefaultResponse dr = new DefaultResponse(new GetUserResponseData(findUser.getEmail(), findUser.getName()));
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to get users.
	 *
	 * @param jwt
	 * @return
	 */
	@GetMapping("/list")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getUsers(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse(us.findAll());
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to sign up.
	 *
	 * @param suf
	 * @return
	 */
	@PostMapping("/sign/up")
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addUser(@RequestBody final SignUpForm suf) {
		if (us.isEmailExist(suf.getEmail())) {
			LOG.warn(Strings.ALREADY_EXIST_EMAIL);

			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ALREADY_EXIST_EMAIL);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		if (us.isPhoneNumberExist(suf.getPhoneNumber())) {
			LOG.warn(Strings.ALREADY_EXIST_PHONE_NUMBER);

			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ALREADY_EXIST_PHONE_NUMBER);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		// User u = new User(suf.getEmail(), suf.getPassword(), suf.getName(),
		// suf.getPhoneNumber());
		// us.addUser(u);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to update a user.
	 *
	 * @param jwt
	 * @param u
	 * @param uuf
	 * @return
	 */
	@PutMapping("/{idx}")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> updateUser(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @RequestBody final UpdateUserForm uuf) {
		u.setEmail(uuf.getEmail());
		u.setName(uuf.getName());
		u.setPassword(uuf.getPassword());
		u.setPhoneNumber(uuf.getPhoneNumber());
		us.updateUser(u);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to delete a user.
	 *
	 * @param jwt
	 * @param u
	 * @return
	 */
	@DeleteMapping("/sign/away")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> deleteUser(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u) {
		us.deleteUser(u.getIdx());

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}
}