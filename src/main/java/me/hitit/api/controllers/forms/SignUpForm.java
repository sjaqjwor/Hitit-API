package me.hitit.api.controllers.forms;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SignUpForm class.
 *
 * @author cheoljin_k
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
	private static final Logger LOG = Logger.getLogger(SignUpForm.class.getSimpleName());

	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String name;
	@NotNull
	private String phoneNumber;
}