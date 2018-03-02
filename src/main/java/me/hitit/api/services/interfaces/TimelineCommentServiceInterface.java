package me.hitit.api.services.interfaces;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.domains.User;

import java.util.List;

public interface TimelineCommentServiceInterface {
    /**
     * Methods to get a timelineComment by index.
     */
    public List<TimelineComment> getTimelineComment(final Long tidx, final String sort, final Long page);

    /**
     * Methods to add a timelineComment by index.
     *
     * @param u
     * @param atcf
     */
    public void addTimelineComment(final User u, AddTimelineCommentsForm atcf);

    /**
     * Methods to update a timelineComment by index.
     *
     * @param u
     * @param utcf
     * @param tidx
     * @param tcidx
     */
    public void updateTimelineComment(final User u, final UpdateTimelineCommentForm utcf, Long tidx, Long tcidx);
    /**
     * Methods to update a timelineComment by index.
     *
     * @param tidx
     * @param tcidx
     */
    public void deleteTimelineComment(final Long tcidx, final Long tidx);
}
