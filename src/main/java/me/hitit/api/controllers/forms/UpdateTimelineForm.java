package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import me.hitit.api.domains.Timeline.OpenRange;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTimelineForm {
    @NonNull
    private OpenRange openRange;
    @NonNull
    private String contents;
}