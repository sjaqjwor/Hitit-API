package me.hitit.api.repositories.querydsls;

import com.querydsl.core.types.OrderSpecifier;
import lombok.NonNull;
import me.hitit.api.domains.Friend;
import me.hitit.api.domains.QFriend;
import me.hitit.api.domains.QUser;
import me.hitit.api.repositories.querydsls.interfaces.FriendQuerydslInterface;
import me.hitit.api.utils.querydsls.SearchKeyword;
import me.hitit.api.utils.sort.ToSorts;
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
        ToSorts ts = new ToSorts(sorts);
        OrderSpecifier[] oss = ts.getToSorts();
        return from(qf)
                .join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx).and(qf.isBlock.eq(false)))
                .orderBy(oss)
                .limit(page)
                .fetch();
    }

    @Nullable
    @Override
    public List<Friend> getBlockFriends(@NonNull Long tuidx, @NonNull String[] sorts, @NonNull Long page) {
        ToSorts ts = new ToSorts(sorts);
        OrderSpecifier[] oss = ts.getToSorts();
        return from(qf)
                .join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx).and(qf.isBlock.eq(true)))
                .orderBy(oss)
                .limit(page)
                .fetch();
    }

    @Nullable
    @Override
    public Friend updateFriend(@NonNull Long tuidx, @NonNull Long fuidx) {
        return from(qf)
                .join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx)
                        .and(qf.friendPk.friendUser.idx.eq(fuidx)))
                .fetchOne();
    }

    @Nullable
    @Override
    public List<Friend> getFindFriends(@NonNull Long tuidx, @NonNull String[] sorts,
                                       @NonNull Long page, @NonNull String keyword) {
        ToSorts ts = new ToSorts(sorts);
        OrderSpecifier[] oss = ts.getToSorts();
        SearchKeyword sk = new SearchKeyword(keyword);
        return from(qf)
                .join(qf.friendPk.targetUser, qu)
                .where(qf.friendPk.targetUser.idx.eq(tuidx)
                        .and(qf.friendPk.friendUser.email.like(
                                sk.getSearchKeyword(keyword))
                                .or(qf.friendPk.friendUser.name.like(
                                        sk.getSearchKeyword(keyword)))
                                .or(qf.friendPk.friendUser.phoneNumber.like(
                                        sk.getSearchKeyword(keyword)))))
                .orderBy(oss)
                .limit(page)
                .fetch();
    }
}
