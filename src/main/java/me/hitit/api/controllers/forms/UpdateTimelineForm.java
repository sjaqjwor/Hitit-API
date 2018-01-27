package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.Timeline.OpenRange;

/**
 * UpdateTimelineForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTimelineForm {
	private static final Logger LOG = Logger.getLogger(UpdateTimelineForm.class.getSimpleName());

	private OpenRange openRange;
	private String contents;
}