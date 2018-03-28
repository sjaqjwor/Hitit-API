package me.hitit.api.services.interfaces;

import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.domains.Friend;
import me.hitit.api.dtos.FriendDTO;

import java.util.List;

public interface FriendServiceInterface {
    void addFriend(final Friend f);

    List<Friend> getFriends(Long tuidx, String sort, Long page);

    Friend updateFriendBlock(Long tuidx, Long fuidx, UpdateFriendBlockForm ufbf);

    List<Friend> getFindFriends(Long tuidx, String sort, Long page, String keyword);

    List<FriendResponseData> getFriendsDto(Long tuidx, String sort, Long page);
}
