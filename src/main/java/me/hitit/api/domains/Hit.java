package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idx")
	private long idx;

	@ManyToOne
	@JoinColumn(name = "uidx")
	private User user;

	@ManyToOne
	@JoinColumn(name = "tidx")
	private Timeline timeline;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
}