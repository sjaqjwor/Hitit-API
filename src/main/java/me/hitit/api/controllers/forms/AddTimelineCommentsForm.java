package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

<<<<<<< HEAD
import javax.validation.constraints.NotNull;

/**
 * AddTimelineCommentsForm class.
 * 
 * @author devetude
 */
=======
>>>>>>> fe7a64dc19d961cc8f8b4e0e5068ac9b187684bf
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTimelineCommentsForm {
<<<<<<< HEAD
	private static final Logger LOG = Logger.getLogger(AddTimelineCommentsForm.class.getSimpleName());

	@NotNull
	private Long tidx;
	@NotNull
	private String contents;
=======
    @NonNull
    private Long tidx;
    @NonNull
    private String contents;
>>>>>>> fe7a64dc19d961cc8f8b4e0e5068ac9b187684bf
}