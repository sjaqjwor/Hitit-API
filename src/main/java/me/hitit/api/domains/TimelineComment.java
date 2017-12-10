//package me.hitit.api.domains;
//
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class TimelineComment {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "idx")
//	private long idx;
//
//	@ManyToOne
//	@JoinColumn(name = "tidx")
//	private User tidx;
//
//	@ManyToOne
//	@JoinColumn(name = "uidx")
//	private User uidx;
//
//	@Column(name = "contents")
//	private String contents;
//
//	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Timestamp ts;
//
//	public TimelineComment() {
//
//	}
//
//	public TimelineComment(long tidx, long uidx, String contents){
//		this.tidx = tidx;
//		this.uidx = uidx;
//		this.contents = contents;
//	}
//
//	public long getIdx() {
//		return idx;
//	}
//
//	public void setIdx(long idx) {
//		this.idx = idx;
//	}
//
//	public long getTidx() {
//		return tidx;
//	}
//
//	public void setTidx(long tidx) {
//		this.tidx = tidx;
//	}
//
//	public long getUidx() {
//		return uidx;
//	}
//
//	public void setUidx(long uidx) {
//		this.uidx = uidx;
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
//
//}
