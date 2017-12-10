package me.hitit.api.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddFriendForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.domains.Friend;
import me.hitit.api.services.FriendService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.log.ControllerLog;

/**
 * FriendController class.
 *
 * @author cheoljin_k
 */
@RestController
@RequestMapping("friend")
@Api
public class FriendController {
	private static final Logger LOG = Logger.getLogger(FriendController.class.getSimpleName());

	@Autowired
	private FriendService fs;

	@PostMapping("")
	@Auth
	@ControllerLog
	@Transactional
	public @ResponseBody ResponseEntity<DefaultResponse> addFrined(@RequestHeader("Authorization") final String jwt,
			@RequestBody final List<AddFriendForm> aff) {
		for(int i=0; i<aff.size(); i++) {
			Friend f = new Friend(aff.get(i).getTargetUser(), aff.get(i).getFriendUser());
			fs.addFriend(f);
		}

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);

		// TODO friend list save transaction;
	}
}
