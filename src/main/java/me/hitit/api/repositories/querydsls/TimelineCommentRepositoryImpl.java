package me.hitit.api.repositories.querydsls;


import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimplePath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.hitit.api.domains.QTimelineComment;
import me.hitit.api.domains.QUser;
import me.hitit.api.domains.TimelineComment;
import me.hitit.api.repositories.querydsls.interfaces.TimelineCommentQuerydslInterface;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TimelineCommentRepositoryImpl extends QueryDslRepositorySupport implements TimelineCommentQuerydslInterface {
private static final Logger LOG = Logger.getLogger(TimelineCommentRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

	private JPAQueryFactory jqf = new JPAQueryFactory(this.getEntityManager());
	private QTimelineComment qtc = QTimelineComment.timelineComment;
	private QUser qu = QUser.user;

	public TimelineCommentRepositoryImpl() {
		super(TimelineComment.class);
	}

	@Override
	public List<TimelineComment> getTimelineComment(Long tidx, String[] sorts, Long page) {
		OrderSpecifier obj[] = new OrderSpecifier[sorts.length];
		for (int a = 0; a < sorts.length; a++) {
			Order order = sorts[a].substring(0, 1).equals("+") ? Order.ASC : Order.DESC;
			SimplePath<Object> filedPath = Expressions.path(Object.class, qtc,
					sorts[a].substring(1, sorts[a].length()));
			obj[a] = new OrderSpecifier(order, filedPath);
		}

		return from(qtc).join(qtc.user, qu).where(qtc.timeline.idx.eq(tidx)).orderBy(obj).limit(page)
				.fetch();
	}
}
