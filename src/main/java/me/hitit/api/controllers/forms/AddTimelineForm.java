package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.Timeline.OpenRange;

/**
 * AddTimelineForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTimelineForm {
	private static final Logger LOG = Logger.getLogger(AddTimelineForm.class.getSimpleName());

	private OpenRange openRange;
	private String contents;
}