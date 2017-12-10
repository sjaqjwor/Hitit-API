package me.hitit.api.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;

/**
 * Friend class.
 *
 * @author cheoljin_k
 *
 */
@Entity
public class Friend {
	private static final Logger LOG = Logger.getLogger(Friend.class.getSimpleName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@ManyToOne
	@JoinColumn(name = "tuidx")
	private User targetUser;

	@ManyToOne
	@JoinColumn(name = "fuidx")
	private User friendUser;


	/**
	 * Constructor.
	 */
	public Friend() {
		LOG.debug("Friend");
	}

	/**
	 * Constructor.
	 *
	 * @param targetUser
	 * @param friendUser
	 */
	public Friend(User targetUser, User friendUser) {
		super();
		this.targetUser = targetUser;
		this.friendUser = friendUser;
	}

	/**
	 * Constructor.
	 *
	 * @param idx
	 * @param targetUser
	 * @param friendUser
	 */
	public Friend(long idx, User targetUser, User friendUser) {
		super();
		this.idx = idx;
		this.targetUser = targetUser;
		this.friendUser = friendUser;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(final long idx) {
		this.idx = idx;
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
