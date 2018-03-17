package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.domains.User;
import me.hitit.api.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("")
@Api
public class TimelineCommentController {
    @GetMapping("timeline/{tidx}/comments")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getTimelineComments(
            @RequestHeader("Authorization") String jwt, @ApiIgnore User u, @RequestParam("page") Long page,
            @RequestParam("sort") String sort, @PathVariable("tidx") Long tidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PostMapping("timeline/comment")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addTimelineComment(
            @RequestHeader("Authorization") String jwt, AddTimelineCommentsForm atcf) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PutMapping("timeline/{tidx}/comment/{tcidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateTimelineComment(
            @RequestHeader("Authorization") String jwt, @PathVariable("tidx") Long tidx,
            @PathVariable("tcidx") Long tcidx, UpdateTimelineCommentForm utcf) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @DeleteMapping("timeline/{tidx}/comment/{tcidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> deleteTimelineComment(
            @RequestHeader("Authorization") String jwt, @PathVariable("tidx") Long tidx,
            @PathVariable("tcidx") Long tcidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }
}
