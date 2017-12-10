package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

/**
 * SignUpForm Class.
 *
 * @author cheoljin_k
 *
 */
public class SignUpForm {
	private static final Logger LOG = Logger.getLogger(SignUpForm.class.getSimpleName());

	private String email;
	private String password;
	private String name;
	private String phoneNumber;

	/**
	 * Constructor.
	 */
	public SignUpForm() {
		LOG.debug("SignUpForm");
	}

	/**
	 * Constructor.
	 *
	 * @param email
	 * @param password
	 * @param name
	 * @param phone_umber
	 */
	public SignUpForm(final String email, final String password, final String name, final String phoneNumber) {
		LOG.debug("SignUpForm");

		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
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

	/**
	 * Methods to get name.
	 *
	 * @return
	 */
	public String getName() {
		LOG.debug("getName");

		return name;
	}

	/**
	 * Methods to set name.
	 *
	 * @param name
	 */
	public void setName(final String name) {
		LOG.debug("setName");

		this.name = name;
	}

	/**
	 * Methods to get phone number.
	 *
	 * @return
	 */
	public String getPhoneNumber() {
		LOG.debug("getPhoneNumber");

		return phoneNumber;
	}

	/**
	 * Methods to set phone number.
	 *
	 * @param phoneNumber
	 */
	public void setPhoneNumber(final String phoneNumber) {
		LOG.debug("setPhoneNumber");

		this.phoneNumber = phoneNumber;
	}

}
