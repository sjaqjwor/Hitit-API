package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import me.hitit.api.domains.Message.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMessageForm {
    @NonNull
    private Type type;
    @NonNull
    private String contents;
}
