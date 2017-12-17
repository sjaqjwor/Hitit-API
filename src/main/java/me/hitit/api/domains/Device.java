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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	@Getter
	@AllArgsConstructor
	public enum Type {
		ANDROID((short) 0), IOS((short) 1);

		private short code;
	}
}
