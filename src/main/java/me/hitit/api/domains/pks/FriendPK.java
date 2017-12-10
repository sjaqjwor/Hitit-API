package me.hitit.api.domains.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import me.hitit.api.domains.User;

@Data
@Embeddable
public class FriendPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne()
	@JoinColumn(name = "tuidx")
	private User targetUser;

	@ManyToOne()
	@JoinColumn(name = "fuidx")
	private User friendUser;

	public FriendPK() {
	}

	public FriendPK(User targetUser, User friendUser) {
		this.targetUser = targetUser;
		this.friendUser = friendUser;
	}
}
