package me.hitit.api.services;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.domains.Timeline;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.domains.User;
import me.hitit.api.exceptions.timeline.TimelineNotFoundException;
import me.hitit.api.repositories.TimelineCommentRepository;
import me.hitit.api.repositories.TimelineRepository;
import me.hitit.api.services.interfaces.TimelineCommentServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TimelineCommentService")
public class TimelineCommentService implements TimelineCommentServiceInterface {
    private static final Logger LOG = Logger.getLogger(TimelineCommentService.class);

    @Autowired
    private TimelineCommentRepository tcr;

    @Autowired
    private TimelineRepository tr;

    @Override
    public List<TimelineComment> getTimelineComment(Long tidx, String sort, Long page) {

        Timeline timeline = tr.findByIdx(tidx);
        if (timeline == null) {
            throw new TimelineNotFoundException();
        }
        String[] sorts = sort.split(",");
        return tcr.getTimelineComment(tidx, sorts, page);
    }

    @Override
    public void addTimelineComment(final User u, final AddTimelineCommentsForm atcf) {
        System.err.println(atcf.getTidx() + "asdasd");
        Timeline t = tr.findByIdx(atcf.getTidx());
        if (t == null) {
            throw new TimelineNotFoundException();
        }
        tcr.save(TimelineComment.builder().contents(atcf.getContents()).timeline(t).user(u).build());
    }

    @Override
    public void updateTimelineComment(final User u, final UpdateTimelineCommentForm utcf, Long tidx, Long tcidx) {
        Timeline t = tr.findByIdx(tidx);
        if (t == null) {
            throw new TimelineNotFoundException();
        }
        tcr.save(TimelineComment.builder().user(u).idx(tcidx).contents(utcf.getContents()).timeline(t).build());
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
