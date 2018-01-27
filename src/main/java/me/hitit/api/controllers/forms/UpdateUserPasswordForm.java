package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UpdateUserPasswordForm class.
 * 
 * @author devetude
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPasswordForm {
	private static final String TAG = UpdateUserPasswordForm.class.getSimpleName();
	
	private String password;
}