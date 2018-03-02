package me.hitit.api.repositories.querydsls;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.hitit.api.domains.QUser;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryQuerydsl extends QueryDslRepositorySupport implements UserQuerydslInterface {
	private static final Logger LOG = Logger.getLogger(UserRepositoryQuerydsl.class.getSimpleName());

	private QUser qu = QUser.user;

	@Autowired
	private JPAQueryFactory jqf;

	public UserRepositoryQuerydsl() {
		super(User.class);
	}

	@Override
	public User getUserByIdx(Long idx) {
		LOG.debug("get user by idx in querydsl");
		return from(qu).where(qu.idx.eq(idx)).fetchOne();
	}

	@Override
	public User getUserByEmail(String email) {
		return from(qu).where(qu.email.eq(email))
				.fetchOne();
	}

	@Override
	public User getUserByPhoneNumber(String phoneNumber) {
		return from(qu).where(qu.phoneNumber.eq(phoneNumber))
				.fetchOne();
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return from(qu).where(qu.email.eq(email).and(qu.password.eq(password)))
				.fetchOne();
	}

}