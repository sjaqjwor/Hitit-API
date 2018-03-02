package me.hitit.api.controllers.responses.data.timelinecomment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.data.user.UserResponseData;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimelineCommentResponseData {
    private static final Logger LOG = Logger.getLogger(TimelineCommentResponseData.class);

    private Long tcidx;
    private String contents;
    private String ts;
    private UserResponseData userResponseData;
}
