package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

/**
 * UpdateUserForm class.
 * 
 * @author cheoljin_k, devetude
 */
public class UpdateUserForm {
	private static final Logger LOG = Logger.getLogger(UpdateUserForm.class.getSimpleName());

	private String email;
	private String password;
	private String name;
	private String phoneNumber;

	/**
	 * Constructor.
	 */
	public UpdateUserForm() {
		LOG.debug("UpdateUserForm");
	}

	/**
	 * Constructor.
	 */
	public UpdateUserForm(final String email, final String password, final String name, final String phoneNumber) {
		LOG.debug("UpdateUserForm");

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
		return email;
	}

	/**
	 * Methods to set email.
	 * 
	 * @param email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Methods to get password.
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Methods to set password.
	 * 
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Methods to get name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Methods to set name.
	 * 
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Methods to get phone number.
	 * 
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Methods to set phone number.
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}