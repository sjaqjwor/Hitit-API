package me.hitit.api.controllers.forms;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SignInForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInForm {
	private static final Logger LOG = Logger.getLogger(SignInForm.class.getSimpleName());

	@NotNull
	private String email;
	@NotNull
	private String password;
}