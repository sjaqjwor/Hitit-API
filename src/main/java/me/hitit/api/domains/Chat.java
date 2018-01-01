//package me.hitit.api.domains;
//
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
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
//public class Chat {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "idx")
//	private long idx;
//
//	@Column(name = "title")
//	private String title;
//
//	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Timestamp ts;
//
//	@ManyToOne
//	@JoinColumns({ @JoinColumn(name = "cidx"), @JoinColumn(name = "uidx") })
//	@JsonIgnore
//	private ChatMemberPrimaryKey chatMemberPk;
//}