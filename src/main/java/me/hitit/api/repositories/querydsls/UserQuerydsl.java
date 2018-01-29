package me.hitit.api.repositories.querydsls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import me.hitit.api.domains.QUser;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;
import me.hitit.api.services.UserService;

@Repository
public class UserQuerydsl extends QueryDslRepositorySupport implements UserQuerydslInterface {
	private static final Logger LOG = Logger.getLogger(UserQuerydsl.class.getSimpleName());

	@PersistenceContext
	private EntityManager em;

	private JPAQueryFactory jqf = new JPAQueryFactory(this.getEntityManager());
	private QUser qu = QUser.user;

	public UserQuerydsl() {
		super(User.class);
	}

	@Override
	public User getUserByIdx(long idx) {
		LOG.debug("get user by idx in querydsl");
		return jqf.selectFrom(qu)
				.where(qu.idx.eq(idx))
				.fetchOne();
	}

	@Override
	public User getUserByEmail(String email) {
		return jqf.selectFrom(qu)
				.where(qu.email.eq(email))
				.fetchOne();
	}

	@Override
	public User getUserByPhoneNumber(String phoneNumber) {
		return jqf.selectFrom(qu)
				.where(qu.phoneNumber.eq(phoneNumber))
				.fetchOne();
	}
}