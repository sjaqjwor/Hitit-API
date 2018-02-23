package me.hitit.api.controllers.forms;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UpdateUserPasswordForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPasswordForm {
	private static final Logger LOG = Logger.getLogger(UpdateUserPasswordForm.class.getSimpleName());

	@NotNull
	private String password;
}