package me.hitit.api.controllers.forms;

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

	private String email;
	private String password;
	private String name;
	private String phoneNumber;
}