package me.hitit.api.repositories.querydsls.interfaces;

import lombok.NonNull;
import me.hitit.api.domains.Friend;

import java.util.List;

public interface FriendQuerydslInterface {
    List<Friend> getFriends(@NonNull Long tuidx, @NonNull String[] sort, @NonNull Long page);

    Friend updateFriend(@NonNull Long tuidx, @NonNull Long fuidx);

    List<Friend> getFindFriends(@NonNull Long tuidx, @NonNull String[] sort, @NonNull Long page, @NonNull String keyword);
}
