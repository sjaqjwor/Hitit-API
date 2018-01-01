//package me.hitit.api.domains;
//
//import java.sql.Timestamp;
//import java.util.Collection;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import me.hitit.api.domains.primary_keys.ChatMemberPrimaryKey;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ChatMember {
//	@EmbeddedId
//	private ChatMemberPrimaryKey chatMemberPk;
//
//	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Timestamp ts;
//
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "chat")
//	private Collection<Chat> chats;
//}