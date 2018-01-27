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
import me.hitit.api.controllers.forms.AddTimelineForm;
import me.hitit.api.controllers.forms.UpdateTimelineForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.Timeline.OpenRange;
import me.hitit.api.domains.User;
import me.hitit.api.utils.auth.Auth;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("")
@Api
public class TimelineController {
	private static final Logger LOG = Logger.getLogger(TimelineController.class.getSimpleName());

	@GetMapping("timeline/{tidx}")
	@Auth
	public ResponseEntity<DefaultResponse> getTimeline(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @PathVariable("tidx") final Long tidx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@GetMapping("timelines/{uidx}")
	@Auth
	public ResponseEntity<DefaultResponse> getTimelines(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @RequestParam("page") long page, @RequestParam("sort") String sort,
			@PathVariable("uidx") final Long uidx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@PostMapping("timeline")
	@Auth
	public ResponseEntity<DefaultResponse> addTimeLine(@RequestHeader("Authorization") final String jwt,
			final AddTimelineForm atl) {
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@PutMapping("timeline/{tidx}")
	@Auth
	public ResponseEntity<DefaultResponse> updateTimeLine(@RequestHeader("Authorization") final String jwt,
			@PathVariable("tidx") final Long tidx, final UpdateTimelineForm utf) {
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@PutMapping("timeline/{tidx}/hits")
	@Auth
	public ResponseEntity<DefaultResponse> updateTimelineHit(@RequestHeader("Authorization") final String jwt,
			@PathVariable("tidx") final Long tidx) {
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@PutMapping("timeline/{tidx}/openRange/{openRange}")
	@Auth
	public ResponseEntity<DefaultResponse> updateTimelineShare(@RequestHeader("Authorization") final String jwt,
			@PathVariable("tidx") final Long tidx, @PathVariable("openRange") final OpenRange openRange) {
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	@DeleteMapping("timeline/{tidx}")
	@Auth
	public ResponseEntity<DefaultResponse> deleteTimeline(@RequestHeader("Authorization") final String jwt,
			@PathVariable("tidx") final Long tidx) {
		DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}
}