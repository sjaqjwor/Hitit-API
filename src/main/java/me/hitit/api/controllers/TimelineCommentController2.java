package me.hitit.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.utils.auth.Auth;

public class TimelineCommentController2 {

	@PostMapping("timeline/{tidx}/comment")
	@Auth
	public ResponseEntity<DefaultResponse> addComment(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
	
	@PutMapping("timeline/{tidx}/comment/{tcidx}")
	@Auth
	public ResponseEntity<DefaultResponse> updateComment(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
	@DeleteMapping("timeline/{tidx}/comment/{tcidx}")
	@Auth
	public ResponseEntity<DefaultResponse> deleteComment(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
}
