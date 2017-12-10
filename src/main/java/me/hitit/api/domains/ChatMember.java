package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import me.hitit.api.domains.pks.ChatMemberPK;

@Data
@Entity
public class ChatMember {

	@EmbeddedId
	private ChatMemberPK chatMemberPk;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

}
