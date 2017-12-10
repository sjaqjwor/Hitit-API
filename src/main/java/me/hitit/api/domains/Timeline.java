//package me.hitit.api.domains;
//
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import org.springframework.data.annotation.Id;
//
//@Entity
//public class Timeline {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "idx")
//	private long idx;
//
//	@ManyToOne
//	@JoinColumn(name = "uidx")
//	private User user;
//
//	@Column(name = "latitude")
//	private double latitude;
//
//	@Column(name = "longitude")
//	private double longitude;
//
//	@Column(name = "openRange")
//	private short openRange;
//
//	@Column(name = "contents")
//	private String contents;
//
//	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Timestamp ts;
//
//	public Timeline(){
//
//	}
//
//	public Timeline(long idx, User user, double latitude, double longitude, short openRange, String contents,
//			Timestamp ts) {
//		super();
//		this.idx = idx;
//		this.user = user;
//		this.latitude = latitude;
//		this.longitude = longitude;
//		this.openRange = openRange;
//		this.contents = contents;
//		this.ts = ts;
//	}
//
//
//	public long getIdx() {
//		return idx;
//	}
//
//	public void setIdx(long idx) {
//		this.idx = idx;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public double getLatitude() {
//		return latitude;
//	}
//
//	public void setLatitude(double latitude) {
//		this.latitude = latitude;
//	}
//
//	public double getLongitude() {
//		return longitude;
//	}
//
//	public void setLongitude(double longitude) {
//		this.longitude = longitude;
//	}
//
//	public short getOpenRange() {
//		return openRange;
//	}
//
//	public void setOpenRange(short openRange) {
//		this.openRange = openRange;
//	}
//
//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}
//
//	public Timestamp getTs() {
//		return ts;
//	}
//
//	public void setTs(Timestamp ts) {
//		this.ts = ts;
//	}
//
//}
