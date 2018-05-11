package me.hitit.api.services.interfaces;

import lombok.NonNull;
import me.hitit.api.controllers.responses.data.friend.BlockFriendsResponseData;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.domains.Friend;

import javax.annotation.Nullable;
import java.util.List;

public interface FriendServiceInterface {
    void addFriend(@NonNull Friend f);

    void updateFriendBlock(@NonNull Long tuidx, @NonNull Long fuidx, @Nullable Boolean changeBlock);

    List<FriendResponseData> getFindFriends(@NonNull Long tuidx, @NonNull String sort, @NonNull Long page, @NonNull String keyword);

    List<FriendResponseData> getFriends(@NonNull Long tuidx, @NonNull String sort, @NonNull Long page);

    List<BlockFriendsResponseData> getBlockFriends(@NonNull Long tuidx, @NonNull String sort, @NonNull Long page);
}
