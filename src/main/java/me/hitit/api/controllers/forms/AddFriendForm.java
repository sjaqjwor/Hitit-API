package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import me.hitit.api.domains.User;

public class AddFriendForm {
	private static final Logger LOG = Logger.getLogger(AddFriendForm.class.getSimpleName());

	private User targetUser;
	private User friendUser;

	/**
	 * Constructor.
	 */
	public AddFriendForm() {
		LOG.debug("AddFriendForm");
	}


	/**
	 * Constructor.
	 *
	 * @param targetUser
	 * @param friendUser
	 */
	public AddFriendForm(User targetUser, User friendUser) {
		super();
		this.targetUser = targetUser;
		this.friendUser = friendUser;
	}


	public User getTargetUser() {
		return targetUser;
	}


	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}


	public User getFriendUser() {
		return friendUser;
	}


	public void setFriendUser(User friendUser) {
		this.friendUser = friendUser;
	}
}
