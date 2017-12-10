package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idx")
	private Long idx;

	@ManyToOne
	@JoinColumn(name = "cidx")
	private User user;

	@Column(name="type")
	private Type type;

	@Column(name="contents")
	private String contents;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public enum Type {
		NORMAL((short) 0), TIMELINE((short) 1), IMAGE((short) 2);

		private short code;

		private Type(final short code) {
			this.code = code;
		}

		public short getCode() {
			return code;
		}
	}

	public Message() {
		super();
	}

	public Message(Long idx, User user, Type type, String contents, Timestamp ts) {
		super();
		this.idx = idx;
		this.user = user;
		this.type = type;
		this.contents = contents;
		this.ts = ts;
	}

	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}
