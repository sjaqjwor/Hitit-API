package me.hitit.api.services.interfaces;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.controllers.responses.data.timelinecomment.TimelineCommentResponseData;
import me.hitit.api.domains.User;

import java.util.List;

public interface TimelineCommentServiceInterface {
    List<TimelineCommentResponseData> getTimelineComment(final Long tidx, final String sort, final Long page);

    void addTimelineComment(final User u, AddTimelineCommentsForm atcf);

    void updateTimelineComment(final User u, final UpdateTimelineCommentForm utcf, Long tidx, Long tcidx);

    void deleteTimelineComment(final Long tcidx, final Long tidx);
}
