package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * AddTimelineCommentsForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTimelineCommentsForm {
	private static final Logger LOG = Logger.getLogger(AddTimelineCommentsForm.class.getSimpleName());

	@NotNull
	private Long tidx;
	@NotNull
	private String contents;
}