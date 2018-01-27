package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddChatMember;
import me.hitit.api.controllers.forms.AddMessageForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;

@RestController
@RequestMapping("")
@Api
public class ChatController {
	private static final Logger LOG = Logger.getLogger(ChatController.class.getSimpleName());

	@GetMapping("chats")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getChats(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("chat/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> addChat(@RequestHeader("Authorization") final String jwt,
			@PathVariable("uidx") final Long uidx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("chat/message")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> addMessage(@RequestHeader("Authorization") final String jwt,
			final AddMessageForm amf) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("chat/member")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> addChatMember(@RequestHeader("Authorization") final String jwt,
			final AddChatMember acm) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@DeleteMapping("chat/{cidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> deleteChat(@RequestHeader("Authorization") final String jwt,
			@PathVariable("cidx") final Long cidx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}