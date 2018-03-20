package me.hitit.api.repositories.querydsls;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimplePath;
import me.hitit.api.domains.Friend;
import me.hitit.api.domains.QFriend;
import me.hitit.api.domains.QUser;
import me.hitit.api.repositories.querydsls.interfaces.FriendQuerydslInterface;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendRepositoryImpl extends QueryDslRepositorySupport implements FriendQuerydslInterface {
    private QFriend qf = QFriend.friend;
    private QUser qu = QUser.user;

    public FriendRepositoryImpl() {
        super(Friend.class);
    }

    @Override
    public List<Friend> getFriends(Long tuidx, String[] sorts, Long page) {
        OrderSpecifier obj[] = new OrderSpecifier[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            Order order = sorts[i].substring(0, 1).equals("+") ? Order.ASC : Order.DESC;
            SimplePath<Object> filedPath = Expressions.path(Object.class, qf.friendPk.friendUser, sorts[i].substring(1, sorts[i].length()));
            obj[i] = new OrderSpecifier(order, filedPath);
        }
        return from(qf).join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx))
                .orderBy(obj)
                .limit(page)
                .fetch();
    }

    @Override
    public Friend updateFriend(Long tuidx, Long fuidx) {
        return from(qf).join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx)
                        .and(qf.friendPk.friendUser.idx.eq(fuidx)))
                .fetchOne();
    }

    @Override
    public List<Friend> getFindFriends(Long tuidx, String[] sorts, Long page, String keyword) {
        OrderSpecifier obj[] = new OrderSpecifier[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            Order order = sorts[i].substring(0, 1).equals("+") ? Order.ASC : Order.DESC;
            SimplePath<Object> filedPath = Expressions.path(
                    Object.class, qf.friendPk.friendUser, sorts[i].substring(1, sorts[i].length()));
            obj[i] = new OrderSpecifier(order, filedPath);
        }
        return from(qf).join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx)
                        .and(qf.friendPk.friendUser.email.like(
                                Expressions.asString("%").concat(keyword).concat("%"))
                                .or(qf.friendPk.friendUser.name.like(
                                        Expressions.asString("%").concat(keyword).concat("%")))
                                .or(qf.friendPk.friendUser.phoneNumber.like(
                                        Expressions.asString("%").concat(keyword).concat("%")))))
                .orderBy(obj)
                .limit(page).fetch();
    }
}
