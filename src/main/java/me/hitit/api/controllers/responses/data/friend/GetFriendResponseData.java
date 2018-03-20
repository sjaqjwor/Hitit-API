package me.hitit.api.controllers.responses.data.friend;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class GetFriendResponseData {
    @NonNull
    private List<FriendResponseData> friendResponseDatas;
    @NonNull
    private FriendResponseData friendResponseData;
}
