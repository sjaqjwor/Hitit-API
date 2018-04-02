package me.hitit.api.services.interfaces;

import lombok.NonNull;
import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.domains.Friend;
import me.hitit.api.dtos.FriendDTO;

import javax.annotation.Nullable;
import java.util.List;

public interface FriendServiceInterface {
    void addFriend(@NonNull Friend f);

    List<Friend> getFriends(@NonNull Long tuidx, @NonNull String sort, @NonNull Long page);

    Friend updateFriendBlock(@NonNull Long tuidx, @NonNull Long fuidx, @Nullable UpdateFriendBlockForm ufbf);

    List<Friend> getFindFriends(@NonNull Long tuidx, @NonNull String sort, @NonNull Long page, @NonNull String keyword);

    List<FriendResponseData> getFriendsDto(@NonNull Long tuidx, @NonNull String sort, @NonNull Long page);
}
