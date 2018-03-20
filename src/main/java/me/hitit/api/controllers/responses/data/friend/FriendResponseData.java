package me.hitit.api.controllers.responses.data.friend;

import lombok.NonNull;

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
    private Boolean checkBen;
}
