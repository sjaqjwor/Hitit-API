package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Push {
	private static final Logger LOG = Logger.getLogger(Push.class.getSimpleName());

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

	@Column(name = "isRead")
	private boolean isRead;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public enum Status {
		FAIL(0), SUCCESS(1);

		private int code;

		private Status(int code) {
			this.code = code;
		}

		private int getCode() {
			return code;
		}
	}

	public enum Type {
		UPDATE_TIMELINE(0), ADD_TIMELINE_COMMENT(1), ADD_MESSAGE(2);

		private int code;

		private Type(int code) {
			this.code = code;
		}

		private int getType() {
			return code;
		}
	}
}