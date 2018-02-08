package me.hitit.api.controllers.responses.data;

import org.apache.log4j.Logger;

import me.hitit.api.dtos.UserDto;

/**
 * SignInResponseData class.
 * 
 * @author devetude
 */
public class SignInResponseData {
	private static final Logger LOG = Logger.getLogger(SignInResponseData.class.getSimpleName());

	private String token;
	private UserDto ud;

	/**
	 * Constructor.
	 * 
	 * @param token
	 * @param UserDto
	 */
	public SignInResponseData(final String token, final UserDto ud) {
		LOG.debug("SignInResponseData");

		this.token = token;
		this.ud = ud;
	}
	
	public SignInResponseData() {
		LOG.debug("SignInResponseData");

		this.token = null;
		this.ud = null;
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

	/**
	 * Methods to get UserDto.
	 * 
	 * @return
	 */
	public UserDto getUserDto() {
		LOG.debug("getToken");

		return ud;
	}

	/**
	 * Methods to set UserDto.
	 * 
	 * @param userDto
	 */
	public void setUserDto(final UserDto ud) {
		LOG.debug("setToken");

		this.ud = ud;
	}
}