package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * UpdateTimelineCommentForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTimelineCommentForm {
	private static final Logger LOG = Logger.getLogger(UpdateTimelineCommentForm.class.getSimpleName());

	@NotNull
	private String contents;
}