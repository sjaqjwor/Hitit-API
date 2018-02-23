package me.hitit.api.repositories.querydsls;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.querydsl.jpa.impl.JPAQueryFactory;

import me.hitit.api.domains.QTimelineComment;
import me.hitit.api.domains.QUser;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.TimelineCommentQuerydslInterface;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;

public class TimelineCommentQuerydsl extends QueryDslRepositorySupport implements TimelineCommentQuerydslInterface{
	
	@PersistenceContext
	private EntityManager em;

	private JPAQueryFactory jqf = new JPAQueryFactory(this.getEntityManager());
	private QTimelineComment tc = QTimelineComment.timelineComment;

	public TimelineCommentQuerydsl() {
		super(TimelineComment.class);
	}

	@Override
	public TimelineComment getTimelineComment(Long tidx) {
		// TODO Auto-generated method stub
		return null;
	}
}
