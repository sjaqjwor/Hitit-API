package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddFriendsForm;
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
			@RequestParam("page") Long page, @RequestParam("sort") String sort) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("friends/find/{keyword}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> findFriends(@RequestHeader("Authorization") final String jwt,
			@RequestParam("page") Long page, @RequestParam("sort") String sort,
			@PathVariable("keyword") final String keyword) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("friends")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> addFriends(@RequestHeader("Authorization") final String jwt,
			final AddFriendsForm aff) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("friend/{uidx}/block/{status}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> updateFriendBlock(
			@RequestHeader("Authorization") final String jwt, @PathVariable("uidx") final String uidx,
			@PathVariable("status") final Boolean status) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}