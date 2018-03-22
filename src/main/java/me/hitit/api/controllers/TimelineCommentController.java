package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.data.timelinecomment.GetTimelineCommentResponseData;
import me.hitit.api.controllers.responses.data.timelinecomment.TimelineCommentResponseData;
import me.hitit.api.controllers.responses.data.user.UserResponseData;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.domains.User;
import me.hitit.api.services.TimelineCommentService;
import me.hitit.api.utils.auth.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
@Api
public class TimelineCommentController {

    @Autowired
    private TimelineCommentService tcs;

    @GetMapping("timeline/{tidx}/comments")
    public ResponseEntity<DefaultResponse> getTimelineComments(@RequestHeader("Authorization") final String jwt,
                                                               @RequestParam("page") Long page, @RequestParam("sort") String sort,
                                                               @PathVariable("tidx") final Long tidx) {
        List<TimelineComment> timelineComments = tcs.getTimelineComment(tidx, sort, page);
        List<TimelineCommentResponseData> tcrds = timelineComments.stream().map(tc -> TimelineCommentResponseData.builder().tcidx(tc.getIdx()).contents(tc.getContents()).userResponseData(UserResponseData.builder().idx(tc.getUser().getIdx()).name(tc.getUser().getName()).email(tc.getUser().getEmail()).profileImageKey(tc.getUser().getProfileImageKey()).build()).build()).collect(Collectors.toList());
        GetTimelineCommentResponseData gtcrd = GetTimelineCommentResponseData.builder().timelineResponseData(tcrds).build();
        return new ResponseEntity<>(new DefaultResponse(gtcrd), HttpStatus.OK);
    }

    @PostMapping("timeline/comment")
    @Auth
    public ResponseEntity<DefaultResponse> addTimelineComment(@RequestHeader("Authorization") final String jwt,
                                                              @ApiIgnore final User u, @Valid @RequestBody final AddTimelineCommentsForm atcf) {
        tcs.addTimelineComment(u, atcf);
        return new ResponseEntity<>(new DefaultResponse(), HttpStatus.OK);
    }

    @PutMapping("timeline/{tidx}/comment/{tcidx}")
    @Auth
    public ResponseEntity<DefaultResponse> updateTimelineComment(@RequestHeader("Authorization") final String jwt,
                                                                 @ApiIgnore final User u,
                                                                 @PathVariable("tidx") final Long tidx, @PathVariable("tcidx") final Long tcidx, @Valid @RequestBody final UpdateTimelineCommentForm utcf) {
        tcs.updateTimelineComment(u, utcf, tidx, tcidx);
        return new ResponseEntity<>(new DefaultResponse(), HttpStatus.OK);

    }

    @DeleteMapping("timeline/{tidx}/comment/{tcidx}")
    @Auth
    public ResponseEntity<DefaultResponse> deleteTimelineComment(
            @RequestHeader("Authorization") final String jwt,
            @PathVariable("tidx") final Long tidx, @PathVariable("tcidx") final Long tcidx) {
        tcs.deleteTimelineComment(tcidx, tidx);
        return new ResponseEntity<>(new DefaultResponse(), HttpStatus.OK);
    }
}

