package me.hitit.api.services;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.services.interfaces.TimelineCommentServiceInterface;

public class TimelineCommentService implements TimelineCommentServiceInterface {

	@Override
	public TimelineComment getTimelineComment(Long tidx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTimelineComment(Long tidx, AddTimelineCommentsForm atcf) {
		TimelineComment tc = new TimelineComment();
		
	}

}
