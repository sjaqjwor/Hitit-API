package me.hitit.api.services.interfaces;

import lombok.NonNull;
import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.controllers.responses.data.timelinecomment.TimelineCommentResponseData;
import me.hitit.api.domains.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TimelineCommentServiceInterface {
    List<TimelineCommentResponseData> getTimelineComment(@NonNull Long tidx,@NonNull String sort,@NonNull Long page);

    void addTimelineComment(@NonNull User u,@NonNull AddTimelineCommentsForm atcf);

    void updateTimelineComment(@NonNull User u,@NonNull UpdateTimelineCommentForm utcf,@NonNull Long tidx,@NonNull Long tcidx);

    void deleteTimelineComment(@NonNull Long tcidx,@NonNull Long tidx);
}
