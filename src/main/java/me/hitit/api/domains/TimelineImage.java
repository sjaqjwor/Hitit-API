package me.hitit.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class TimelineImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@ManyToOne
	@JoinColumn(name = "tidx")
	private Timeline timeline;

	@Column(name = "contents")
	private String contents;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public TimelineImage() {

	}

	public TimelineImage(Timeline timeline, String contents) {
		this.timeline = timeline;
		this.contents = contents;
	}
}