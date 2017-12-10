package me.hitit.api.domains.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import me.hitit.api.domains.Chat;
import me.hitit.api.domains.User;

@Data
@Embeddable
public class ChatMemberPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cidx")
	private Chat chat;

	@ManyToOne
	@JoinColumn(name="uidx")
	private User user;

	public ChatMemberPK() {
	}

	public ChatMemberPK(Chat chat, User user) {
		this.chat = chat;
		this.user = user;
	}
}
