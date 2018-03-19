package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddTimelineForm;
import me.hitit.api.controllers.forms.UpdateTimelineForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.Timeline.OpenRange;
import me.hitit.api.domains.User;
import me.hitit.api.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("")
@Api
public class TimelineController {
    @GetMapping("timeline/{tidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getTimeline(
            @RequestHeader("Authorization") String jwt, @ApiIgnore User u, @PathVariable("tidx") Long tidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @GetMapping("timelines/{uidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getTimelines(
            @RequestHeader("Authorization") String jwt, @ApiIgnore User u, @RequestParam("page") long page,
            @RequestParam("sort") String sort, @PathVariable("uidx") Long uidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PostMapping("timeline")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addTimeLine(
            @RequestHeader("Authorization") String jwt, AddTimelineForm atl) {
        DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PutMapping("timeline/{tidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateTimeLine(
            @RequestHeader("Authorization") String jwt, @PathVariable("tidx") Long tidx, UpdateTimelineForm utf) {
        DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PutMapping("timeline/{tidx}/hits")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateTimelineHit(
            @RequestHeader("Authorization") String jwt, @PathVariable("tidx") Long tidx) {
        DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PutMapping("timeline/{tidx}/openRange/{openRange}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateTimelineShare(
            @RequestHeader("Authorization") String jwt, @PathVariable("tidx") Long tidx,
            @PathVariable("openRange") OpenRange openRange) {
        DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @DeleteMapping("timeline/{tidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> deleteTimeline(
            @RequestHeader("Authorization") String jwt, @PathVariable("tidx") Long tidx) {
        DefaultResponse dr = new DefaultResponse(Status.SUCCESS);
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }
}
