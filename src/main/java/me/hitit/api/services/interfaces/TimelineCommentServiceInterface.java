package me.hitit.api.services.interfaces;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.domains.TimelineComment;

public interface TimelineCommentServiceInterface {
	/**
	 * Methods to get a timelineComment by index.
	 */
	public TimelineComment getTimelineComment(final Long tidx);
	/**
	 * Methods to add a timelineComment by index.
	 * 
	 * @param tidx
	 * @param AddTimelineCommentsForm
	 */
	public void addTimelineComment(final Long tidx , AddTimelineCommentsForm atcf);
}
