package me.hitit.api.repositories.querydsls;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import me.hitit.api.domains.QUser;
import me.hitit.api.domains.User;
import me.hitit.api.domains.primary_keys.QFriendPrimaryKey;
import me.hitit.api.dtos.UserDto;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;

@Repository
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserQuerydslInterface {
	private static final Logger LOG = Logger.getLogger(UserRepositoryImpl.class.getSimpleName());

	private QUser qu = QUser.user;
	private QFriendPrimaryKey qfp = QFriendPrimaryKey.friendPrimaryKey;

	@Autowired
	private JPAQueryFactory jqf;

	public UserRepositoryImpl() {
		super(User.class);
	}

	@Override
	public User getUserByIdx(Long idx) {
		LOG.debug("get user by idx in querydsl");
		return from(qu).where(qu.idx.eq(idx)).fetchOne();
	}

	@Override
	public UserDto getUserByEmail(String email) {
		return from(qu).where(qu.email.eq(email))
				.select(Projections.constructor(UserDto.class, qu.idx, qu.name, qu.profileImageKey, qu.email))
				.fetchOne();
	}

	@Override
	public UserDto getUserByPhoneNumber(String phoneNumber) {

		return from(qu).where(qu.phoneNumber.eq(phoneNumber))
				.select(Projections.constructor(UserDto.class, qu.idx, qu.name, qu.profileImageKey, qu.email))
				.fetchOne();
	}

	@Override
	public UserDto getUserByEmailAndPassword(String email, String password) {
		return from(qu).where(qu.email.eq(email).and(qu.password.eq(password)))
				.select(Projections.constructor(UserDto.class, qu.idx, qu.name, qu.profileImageKey, qu.email))
				.fetchOne();
	}

	@Override
	public List<UserDto> getAllUsers(Long page, String sort, String standard) {
		// TODO Auto-generated method stub
		return from(qu).leftJoin(qu, qfp.targetUser)
				.select(Projections.constructor(UserDto.class, qu.idx, qu.name, qu.profileImageKey, qu.email)).fetch();
	}
}