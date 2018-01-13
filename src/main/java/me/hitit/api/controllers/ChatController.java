package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;

@RestController
@Api
public class ChatController {
	private static final Logger LOG = Logger.getLogger(ChatController.class.getSimpleName());

	@GetMapping("Chats")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getChats(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("Chat/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> postChat(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("Chat/message/{cidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> postMessage(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("Chat/{cidx}/ChatMember/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> putChatMember(
			@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("Chat/{cidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> putChatName(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@DeleteMapping
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> deleteChat(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}