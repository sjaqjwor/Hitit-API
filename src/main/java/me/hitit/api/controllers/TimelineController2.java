package me.hitit.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.utils.auth.Auth;

@RestController
@Api
public class TimelineController2 {

	@PostMapping("/timeline")
	@Auth
	public ResponseEntity<DefaultResponse> addTimeLine(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
	
	@PutMapping("timeline/{tidx}")
	@Auth
	public ResponseEntity<DefaultResponse> updateTimeLine(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
	
	@PutMapping("timeline/{tidx}/hits")
	@Auth
	public ResponseEntity<DefaultResponse> updateHit(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
	
	@PutMapping("timeline/{tidx}/share")
	@Auth
	public ResponseEntity<DefaultResponse> updateShare(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}
	
	@DeleteMapping("timeline/{tidx}")
	@Auth
	public ResponseEntity<DefaultResponse> deleteTimeline(@RequestHeader("Authorization") final String jwt){
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr,HttpStatus.OK);
	}

	
}
