package me.hitit.api.repositories.querydsls.interfaces;

import me.hitit.api.domains.TimelineComment;

import java.util.List;

public interface TimelineCommentQuerydslInterface {
	public List<TimelineComment> getTimelineComment(final Long tidx, final String[] sort, final Long page);
}
