package me.hitit.api.controllers.responses.data.user;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserResponseData {
    @NonNull
    private Long idx;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private String profileImageKey;
}
