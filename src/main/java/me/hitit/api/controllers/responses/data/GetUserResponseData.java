package me.hitit.api.controllers.responses.data;

import org.apache.log4j.Logger;

import me.hitit.api.dtos.UserDto;

/**
 * GetUserResponseData class.
 * 
 * @author devetude
 */
public class GetUserResponseData {
	private static final Logger LOG = Logger.getLogger(GetUserResponseData.class.getSimpleName());

	private String email;
	private String name;
	private Long idx;
	private String profileImageKey;

	/**
	 * Constructor.
	 * 
	 * @param email
	 * @param name
	 */
	public GetUserResponseData(final UserDto ud) {
		LOG.debug("GetUserResponseData");
		
		this.idx = ud.getIdx();
		this.email = ud.getEmail();
		this.name = ud.getName();
		this.profileImageKey = ud.getProfileImageKey();
	}

	/**
	 * Methods to get idx.
	 * 
	 * @return
	 */
	public Long getIdx() {
		return idx;
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
	 * Methods to get profileimageKey.
	 * 
	 * @return
	 */
	public String getProfileImageKey() {
		return profileImageKey;
	}

	/**
	 * Methods to set idx.
	 * 
	 * @param idx
	 */
	public void setIdx(Long idx) {
		this.idx = idx;
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

	/**
	 * Methods to set profileimageKey.
	 * 
	 * @return
	 */
	public void setProfileImageKey(String profileImageKey) {
		this.profileImageKey = profileImageKey;
	}
}