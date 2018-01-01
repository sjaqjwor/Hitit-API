package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.primary_keys.ChatMemberPrimaryKey;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMember {
	@EmbeddedId
	private ChatMemberPrimaryKey chatMemberPk;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@MapsId("chatId")
	@ManyToOne
	@JoinColumn(name = "cidx")
	@JsonIgnore
	private Chat chat;
}