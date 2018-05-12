package me.hitit.api.controllers.responses.data.friend;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class GetFriendsResponseData {
    @NonNull
    private List<FriendResponseData> friendResponseData;
    @NonNull
    private List<BlockFriendsResponseData> blockFriendsResponseData;
}
