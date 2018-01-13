package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.domains.User;
import me.hitit.api.utils.auth.Auth;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("")
@Api
public class TimelineCommentController {
	private static final Logger LOG = Logger.getLogger(TimelineCommentController.class.getSimpleName());

	@GetMapping("timeline/{tidx}/comments")
	public ResponseEntity<DefaultResponse> getTimelineComments(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @PathVariable("tidx") final long tidx, @RequestParam("page") long page,
			@RequestParam("sort") String sort) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@PostMapping("timeline/{tidx}/comment")
	@Auth
	public ResponseEntity<DefaultResponse> addComment(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@PutMapping("timeline/{tidx}/comment/{tcidx}")
	@Auth
	public ResponseEntity<DefaultResponse> updateComment(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@DeleteMapping("timeline/{tidx}/comment/{tcidx}")
	@Auth
	public ResponseEntity<DefaultResponse> deleteComment(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}
}