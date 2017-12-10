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
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idx")
	private Long idx;

	@ManyToOne
	@JoinColumn(name = "uidx")
	private User user;

	@Column(name="latitude")
	private double latitude;

	@Column(name="longiude")
	private double longiude;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public Location() {
		super();
	}

	public Location(Long idx, User user, double latitude, double longiude, Timestamp ts) {
		super();
		this.idx = idx;
		this.user = user;
		this.latitude = latitude;
		this.longiude = longiude;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongiude() {
		return longiude;
	}

	public void setLongiude(double longiude) {
		this.longiude = longiude;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}


}
