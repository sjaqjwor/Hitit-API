package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.log4j.Logger;

/**
 * Device class.
 *
 * @author yeeeah_j, devetude
 */
@Entity
public class Device {
	private static final Logger LOG = Logger.getLogger(Device.class.getSimpleName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@OneToOne
	@JoinColumn(name = "uidx")
	private User user;

	@Column(name = "type")
	private Type type;

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "token")
	private String token;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	/**
	 * Type enum.
	 *
	 * @author devetude
	 */
	public enum Type {
		ANDROID((short) 0), IOS((short) 1);

		private short code;

		/**
		 * Constructor.
		 *
		 * @param code
		 */
		private Type(final short code) {
			this.code = code;
		}

		/**
		 * Methods to get code.
		 *
		 * @return
		 */
		public short getCode() {
			return code;
		}
	}

	public Device(long idx, User user, Type type, String uuid, String token, Timestamp ts) {
		this.idx = idx;
		this.user = user;
		this.type = type;
		this.uuid = uuid;
		this.token = token;
		this.ts = ts;
	}

	public Device() {
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

}
