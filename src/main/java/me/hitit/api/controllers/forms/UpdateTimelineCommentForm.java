package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

<<<<<<< HEAD
import javax.validation.constraints.NotNull;

/**
 * UpdateTimelineCommentForm class.
 * 
 * @author devetude
 */
=======
>>>>>>> fe7a64dc19d961cc8f8b4e0e5068ac9b187684bf
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTimelineCommentForm {
<<<<<<< HEAD
	private static final Logger LOG = Logger.getLogger(UpdateTimelineCommentForm.class.getSimpleName());

	@NotNull
	private String contents;
}
=======
    @NonNull
    private String contents;
}
>>>>>>> fe7a64dc19d961cc8f8b4e0e5068ac9b187684bf
