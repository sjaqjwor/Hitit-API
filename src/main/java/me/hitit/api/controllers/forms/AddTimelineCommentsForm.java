package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTimelineCommentsForm {
    @NonNull
    private Long tidx;
    @NonNull
    private String contents;
}