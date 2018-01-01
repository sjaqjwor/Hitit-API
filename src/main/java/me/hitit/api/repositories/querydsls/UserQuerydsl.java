package me.hitit.api.repositories.querydsls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;

@Repository
public class UserQuerydsl extends QueryDslRepositorySupport implements UserQuerydslInterface {
	@PersistenceContext
	private EntityManager em;

	private JPAQueryFactory jqf;

	public UserQuerydsl() {
		super(User.class);

		jqf = new JPAQueryFactory(this.getEntityManager());
	}

	@Override
	public User getUserByIdx(long idx) {
		return null;
	}
}