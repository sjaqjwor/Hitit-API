package me.hitit.api.controllers.responses.data.user;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetUserSignInResponseData {
    @NonNull
    private String token;
    @NonNull
    private UserResponseData userResponseData;
}
