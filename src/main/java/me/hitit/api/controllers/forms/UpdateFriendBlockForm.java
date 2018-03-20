package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFriendBlockForm {
    @NonNull
    private Boolean checkBlock;
}
