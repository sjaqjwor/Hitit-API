package me.hitit.api.repositories.querydsls;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimplePath;
import lombok.NonNull;
import me.hitit.api.domains.Friend;
import me.hitit.api.domains.QFriend;
import me.hitit.api.domains.QUser;
import me.hitit.api.repositories.querydsls.interfaces.FriendQuerydslInterface;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.util.List;

@Repository
public class FriendRepositoryImpl extends QueryDslRepositorySupport implements FriendQuerydslInterface {
    @NonNull
    private final QFriend qf = QFriend.friend;
    @NonNull
    private final QUser qu = QUser.user;

    public FriendRepositoryImpl() {
        super(Friend.class);
    }

    @Nullable
    @Override
    public List<Friend> getFriends(@NonNull Long tuidx, @NonNull String[] sorts, @NonNull Long page) {
        OrderSpecifier oss[] = new OrderSpecifier[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            Order order = sorts[i].indexOf(0) == '+'
                    ? Order.ASC
                    : Order.DESC;
            SimplePath<Object> sortProperty = Expressions.path(
                    Object.class,
                    qf.friendPk.friendUser,
                    sorts[i].substring(1, sorts[i].length()));
            oss[i] = new OrderSpecifier(order, sortProperty);
        }
        return from(qf).join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx))
                .orderBy(oss)
                .limit(page)
                .fetch();
    }

    @Nullable
    @Override
    public Friend updateFriend(@NonNull Long tuidx, @NonNull Long fuidx) {
        return from(qf).join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx)
                        .and(qf.friendPk.friendUser.idx.eq(fuidx)))
                .fetchOne();
    }

    @Nullable
    @Override
    public List<Friend> getFindFriends(@NonNull Long tuidx, @NonNull String[] sorts,
                                       @NonNull Long page, @NonNull String keyword) {
        OrderSpecifier oss[] = new OrderSpecifier[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            Order order = sorts[i].indexOf(0) == '+'
                    ? Order.ASC
                    : Order.DESC;
            SimplePath<Object> sortProperty = Expressions.path(
                    Object.class,
                    qf.friendPk.friendUser,
                    sorts[i].substring(1, sorts[i].length()));
            oss[i] = new OrderSpecifier(order, sortProperty);
        }
        return from(qf).join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx)
                        .and(qf.friendPk.friendUser.email.like(
                                Expressions.asString("%").concat(keyword).concat("%"))
                                .or(qf.friendPk.friendUser.name.like(
                                        Expressions.asString("%").concat(keyword).concat("%")))
                                .or(qf.friendPk.friendUser.phoneNumber.like(
                                        Expressions.asString("%").concat(keyword).concat("%")))))
                .orderBy(oss)
                .limit(page)
                .fetch();
    }
}
