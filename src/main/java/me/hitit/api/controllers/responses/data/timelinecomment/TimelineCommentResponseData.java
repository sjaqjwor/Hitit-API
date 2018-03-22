package me.hitit.api.controllers.responses.data.timelinecomment;

import lombok.*;
import me.hitit.api.controllers.responses.data.user.UserResponseData;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimelineCommentResponseData {
    @NonNull
    private Long tcidx;
    @NonNull
    private String contents;
    @NonNull
    private String ts;
    @NonNull
    private UserResponseData userResponseData;
}

