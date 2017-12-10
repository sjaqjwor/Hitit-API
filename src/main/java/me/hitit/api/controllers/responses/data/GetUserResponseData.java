package me.hitit.api.controllers.responses.data;

import org.apache.log4j.Logger;

/**
 * GetUserResponseData class.
 * 
 * @author devetude
 */
public class GetUserResponseData {
	private static final Logger LOG = Logger.getLogger(GetUserResponseData.class.getSimpleName());

	private String email;
	private String name;

	/**
	 * Constructor.
	 * 
	 * @param email
	 * @param name
	 */
	public GetUserResponseData(final String email, final String name) {
		LOG.debug("GetUserResponseData");

		this.email = email;
		this.name = name;
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
	public void setEmail(String email) {
		LOG.debug("setEmail");

		this.email = email;
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
	public void setName(String name) {
		LOG.debug("setName");

		this.name = name;
	}
}