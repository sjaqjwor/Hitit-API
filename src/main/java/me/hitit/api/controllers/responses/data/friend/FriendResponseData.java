package me.hitit.api.controllers.responses.data.friend;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class FriendResponseData {
    @NonNull
    private Long fuidx;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
    @NonNull
    private Boolean isBlock;
}
