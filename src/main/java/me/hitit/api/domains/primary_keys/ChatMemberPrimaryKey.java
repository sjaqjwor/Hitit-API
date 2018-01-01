package me.hitit.api.domains.primary_keys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.Chat;
import me.hitit.api.domains.User;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMemberPrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cidx")
	private Chat chat;

	@ManyToOne
	@JoinColumn(name = "uidx")
	private User user;
}