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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Device class.
 *
 * @author yeeeah_j, devetude
 */
@Entity
@Data
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
	public Device(){
		
	}

	public Device(long idx, User user, Type type, String uuid, String token, Timestamp ts) {
		this.idx = idx;
		this.user = user;
		this.type = type;
		this.uuid = uuid;
		this.token = token;
		this.ts = ts;
	}

}
