package me.hitit.api.controllers.responses.data;

import org.apache.log4j.Logger;

/**
 * SignInResponseData class.
 * 
 * @author devetude
 */
public class SignInResponseData {
	private static final Logger LOG = Logger.getLogger(SignInResponseData.class.getSimpleName());

	private String token;

	/**
	 * Constructor.
	 * 
	 * @param token
	 */
	public SignInResponseData(final String token) {
		LOG.debug("SignInResponseData");

		this.token = token;
	}

	/**
	 * Methods to get token.
	 * 
	 * @return
	 */
	public String getToken() {
		LOG.debug("getToken");

		return token;
	}

	/**
	 * Methods to set token.
	 * 
	 * @param token
	 */
	public void setToken(final String token) {
		LOG.debug("setToken");

		this.token = token;
	}
}