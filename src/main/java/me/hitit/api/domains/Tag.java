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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
	private static final Logger LOG = Logger.getLogger(Device.class.getSimpleName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idx")
	private long idx;

	@ManyToOne
	@JoinColumn(name = "uidx")
	@JsonIgnore
	private User user;

	@ManyToOne
	@JoinColumn(name = "tidx")
	private Timeline Timeline;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
}
