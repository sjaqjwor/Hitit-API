package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

/**
 * SignInForm class.
 * 
 * @author devetude
 */
public class SignInForm {
	private static final Logger LOG = Logger.getLogger(SignInForm.class.getSimpleName());

	private String email;
	private String password;

	/**
	 * Constructor.
	 */
	public SignInForm() {
		LOG.debug("SignInForm");
	}

	/**
	 * Constructor.
	 * 
	 * @param email
	 * @param password
	 */
	public SignInForm(final String email, final String password) {
		LOG.debug("SignInForm");

		this.email = email;
		this.password = password;
	}

	/**
	 * Methods to get email.
	 * 
	 * @return
	 */
	public String getEmail() {
		LOG.debug("getEmail");

		return email;
	}

	/**
	 * Methods to set email.
	 * 
	 * @param email
	 */
	public void setEmail(final String email) {
		LOG.debug("setEmail");

		this.email = email;
	}

	/**
	 * Methods to get password.
	 * 
	 * @return
	 */
	public String getPassword() {
		LOG.debug("getPassword");

		return password;
	}

	/**
	 * Methods to set password.
	 * 
	 * @param password
	 */
	public void setPassword(final String password) {
		LOG.debug("setPassword");
		
		this.password = password;
	}
}