package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AddChatMember class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddChatMember {
	private static final Logger LOG = Logger.getLogger(AddChatMember.class.getSimpleName());

	private Long cidx;
	private Long uidx;
}