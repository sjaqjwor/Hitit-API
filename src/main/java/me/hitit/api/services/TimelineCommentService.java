package me.hitit.api.services;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.controllers.responses.data.timelinecomment.TimelineCommentResponseData;
import me.hitit.api.controllers.responses.data.user.UserResponseData;
import me.hitit.api.domains.Timeline;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.domains.User;
import me.hitit.api.exceptions.timeline.TimelineNotFoundException;
import me.hitit.api.exceptions.timelinecomment.SortException;
import me.hitit.api.repositories.TimelineCommentRepository;
import me.hitit.api.repositories.TimelineRepository;
import me.hitit.api.services.interfaces.TimelineCommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("TimelineCommentService")
public class TimelineCommentService implements TimelineCommentServiceInterface {

    @Autowired
    private TimelineCommentRepository tcr;

    @Autowired
    private TimelineRepository tr;

    @Override
    public List<TimelineCommentResponseData> getTimelineComment(Long tidx, String sort, Long page) {

        Timeline timeline = tr.findByIdx(tidx);
        if (timeline == null) {
            throw new TimelineNotFoundException();
        }
        String[] sorts = (String[])Arrays.stream(sort.split(","))
                .filter(s -> {
                    if(s.charAt(0)!='+'&&s.charAt(0)!='-'){
                            throw  new SortException();
                    }
                    return true;
        }).toArray();
        List<TimelineComment> timelineComments = tcr.getTimelineComment(tidx, sorts, page);
        return Optional.ofNullable(timelineComments).orElse(new ArrayList<>())
                .stream()
                .map(tc -> TimelineCommentResponseData.builder()
                        .tcidx(tc.getIdx())
                        .contents(tc.getContents())
                        .ts(tc.getTs().toString())
                        .userResponseData(UserResponseData.builder()
                                .idx(tc.getUser().getIdx())
                                .name(tc.getUser().getName())
                                .email(tc.getUser().getEmail())
                                .profileImageKey(tc.getUser().getProfileImageKey())
                                .build())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void addTimelineComment(final User u, final AddTimelineCommentsForm atcf) {
        Timeline t = tr.findByIdx(atcf.getTidx());
        if (t == null) {
            throw new TimelineNotFoundException();
        }
        tcr.save(TimelineComment.builder()
                .contents(atcf.getContents())
                .timeline(t)
                .user(u)
                .build());
    }

    @Override
    public void updateTimelineComment(final User u, final UpdateTimelineCommentForm utcf, Long tidx, Long tcidx) {
        Timeline t = tr.findByIdx(tidx);
        if (t == null) {
            throw new TimelineNotFoundException();
        }
        tcr.save(TimelineComment.builder()
                .user(u)
                .idx(tcidx)
                .contents(utcf.getContents())
                .timeline(t)
                .build());
    }

    @Override
    public void deleteTimelineComment(final Long tcidx, final Long tidx) {
        Timeline t = tr.findByIdx(tidx);
        if (t == null) {
            throw new TimelineNotFoundException();
        }
        tcr.delete(tcidx);
    }

}
