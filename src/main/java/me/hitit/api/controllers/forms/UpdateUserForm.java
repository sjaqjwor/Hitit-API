package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UpdateUserForm class.
 * 
 * @author cheoljin_k, devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserForm {
	private static final Logger LOG = Logger.getLogger(UpdateUserForm.class.getSimpleName());

	private String email;
	private String password;
	private String name;
	private String phoneNumber;

}