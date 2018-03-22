package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTimelineCommentsForm {
    @NotNull
    private Long tidx;
    @NotNull
    private String contents;
}
