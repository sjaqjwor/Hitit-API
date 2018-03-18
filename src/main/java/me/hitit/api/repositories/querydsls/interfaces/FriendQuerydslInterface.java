package me.hitit.api.repositories.querydsls.interfaces;

import me.hitit.api.domains.Friend;

import java.util.List;

public interface FriendQuerydslInterface {
    List<Friend> getFriends(Long tuidx, String[] sort, Long page);

    Friend updateFriend(final Long tuidx, final Long fuidx);

    List<Friend> getFindFriends(final Long tuidx, final String[] sort, final Long page, final String keyword);
}
