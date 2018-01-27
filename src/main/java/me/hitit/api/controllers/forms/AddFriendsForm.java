package me.hitit.api.controllers.forms;

import java.util.List;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AddFriendsForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFriendsForm {
	private static final Logger LOG = Logger.getLogger(AddFriendsForm.class.getSimpleName());

	private List<String> phoneNumbers;
}