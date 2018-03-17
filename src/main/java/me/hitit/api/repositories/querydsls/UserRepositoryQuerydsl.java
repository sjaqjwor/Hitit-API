package me.hitit.api.repositories.querydsls;

import me.hitit.api.domains.QUser;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryQuerydsl extends QueryDslRepositorySupport implements UserQuerydslInterface {
    private QUser qu = QUser.user;

    public UserRepositoryQuerydsl() {
        super(User.class);
    }

    @Override
    public User getUserByIdx(Long idx) {
        return from(qu).where(qu.idx.eq(idx)).fetchOne();
    }

    @Override
    public User getUserByEmail(String email) {
        return from(qu).where(qu.email.eq(email)).fetchOne();
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return from(qu).where(qu.phoneNumber.eq(phoneNumber)).fetchOne();
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return from(qu).where(qu.email.eq(email).and(qu.password.eq(password))).fetchOne();
    }
}
