package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.Message.Type;

/**
 * AddMessageForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMessageForm {
	private static final Logger LOG = Logger.getLogger(AddMessageForm.class.getSimpleName());

	private Type type;
	private String contents;
}