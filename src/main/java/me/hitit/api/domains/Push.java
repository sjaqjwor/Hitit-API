package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Push {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "status")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "uidx")
	@JsonIgnore
	private User user;

	@Column(name = "type")
	private Type type;

	@Column(name = "payload", columnDefinition = "TEXT")
	private String payload;

	@Column(name ="isRead")
	private boolean isRead;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;


	public enum Status {
		FAIL(0), SUCCESS(1);

		private int code;

		private Status(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}


	public enum Type {
		//TODO : TYPE ���� ���ϱ�
		UPDATE_TIMELINE(0), ADD_TIMELINE_COMMENT(1), ADD_MESSAGE(2);
		//ADD_NOTICE(0), UPDATE_NOTICE(1), WIFI_REQUEST(2), WIFI_REQUEST_RESULT(3);

		private int code;

		private Type(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public Push(){

	}
	public Push(User user, Type type, Status status, String payload, boolean isRead){
		this.user = user;
		this.status = status;
		this.type = type;
		this.payload = payload;
		this.isRead = isRead;


	}
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}





}
