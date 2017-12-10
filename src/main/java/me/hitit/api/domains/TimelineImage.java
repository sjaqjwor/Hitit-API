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
//import javax.persistence.OneToOne;
//@Entity
//public class TimelineImage {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "idx")
//	private long idx;
//
//	@OneToOne
//	@JoinColumn(name = "tidx")
//	private long tidx;
//
//	@Column(name = "contents")
//	private String contents;
//
//	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Timestamp ts;
//
//	public TimelineImage(){
//
//	}
//	public TimelineImage(long tidx, String contents){
//		this.tidx = tidx;
//		this.contents = contents;
//
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
//
//
//
//}
