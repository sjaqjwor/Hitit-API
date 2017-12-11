package me.hitit.api.domains;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

import javax.persistence.Id;


@Entity
@Data
public class Timeline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@ManyToOne
	@JoinColumn(name = "uidx")
	private User user;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "openRange")
	private short openRange;

	@Column(name = "contents")
	private String contents;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
	private Collection<TimelineComment> timelineComment;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
	private Collection<TimelineImage> timelineImage;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
	private TimelineMusic timelineMusic;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	public Timeline(){
		
	}

	public Timeline(long idx, User user, double latitude, double longitude, short openRange, String contents,
			Timestamp ts) {
		super();
		this.idx = idx;
		this.user = user;
		this.latitude = latitude;
		this.longitude = longitude;
		this.openRange = openRange;
		this.contents = contents;
		this.ts = ts;
	}

	public Collection<TimelineComment> getTimelineComment(){
		if(timelineComment ==null){
			timelineComment = new ArrayList<TimelineComment>();
		}
		return timelineComment;
	}
	
	public void setTimelineComment(Collection<TimelineComment> timelineComment){
		this.timelineComment = timelineComment;
	}
	
	public void addTimelineComment(TimelineComment p){
		Collection<TimelineComment> timelineComment = getTimelineComment();
		timelineComment.add(p);
	}
	
	public Collection<TimelineImage> getTimelineImage(){
		if(timelineImage ==null){
			timelineImage = new ArrayList<TimelineImage>();
		}
		return timelineImage;
	}
	
	public void setTimelineImage(Collection<TimelineImage> timelineComment){
		this.timelineImage= timelineImage;
	}
	
	public void addTimelineImage(TimelineImage p){
		Collection<TimelineImage> timelineImage= getTimelineImage();
		timelineImage.add(p);
	}
	
	
	public TimelineMusic getTimelineMusic() {
		return timelineMusic;
	}

	public void setTimelineMusic(TimelineMusic timelineMusic) {
		this.timelineMusic = timelineMusic;
	}
	
}
