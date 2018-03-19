package me.hitit.api.controllers.responses.data.user;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CheckEmailResponseData {
    @NonNull
    private Boolean exist;
}
