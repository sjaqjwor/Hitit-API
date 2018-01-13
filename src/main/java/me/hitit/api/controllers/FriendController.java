package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;

@RestController
@RequestMapping("")
@Api
public class FriendController {
	private static final Logger LOG = Logger.getLogger(FriendController.class.getSimpleName());

	@GetMapping("friends")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getFriends(@RequestHeader("Authorization") final String jwt,
			@RequestParam("page") long page, @RequestParam("sort") String sort) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("friend/find")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> findFriends(@RequestHeader("Authorization") final String jwt,
			@RequestParam("page") long page, @RequestParam("sort") String sort) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("friends")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> postFriends(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("frineds/sync")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> syncFreinds(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("friend/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> putFriend(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}