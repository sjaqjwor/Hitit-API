package me.hitit.api.controllers.responses.data.timelinecomment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTimelineCommentResponseData {
    private static final Logger LOG = Logger.getLogger(GetTimelineCommentResponseData.class);

    private List<TimelineCommentResponseData> timelineResponseData;
}
