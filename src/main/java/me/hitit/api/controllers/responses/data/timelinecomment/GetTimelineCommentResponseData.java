package me.hitit.api.controllers.responses.data.timelinecomment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTimelineCommentResponseData {
    private List<TimelineCommentResponseData> timelineResponseData;
}
