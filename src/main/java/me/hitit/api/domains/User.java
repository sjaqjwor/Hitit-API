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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.log4j.Logger;

/**
 * User class.
 *
 * @author devetude, cheoljin_k
 */

@Entity
public class User {
	private static final Logger LOG = Logger.getLogger(User.class.getSimpleName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "email")
	private String email;

	@Column(name = "password", columnDefinition = "TEXT")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private Device device;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user" )
	private Collection<Timeline> timeline;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<Push> push;
	


	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public User() {
	}

	public User(long idx, String email, String password, String name, String phoneNumber, Device device, Timestamp ts) {
		this.idx = idx;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.device = device;
		this.ts = ts;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Collection<Timeline> getTimeline(){
		if(timeline ==null){
			timeline = new ArrayList<Timeline>();
		}
		return timeline;
	}
	
	public void setTimeline(Collection<Timeline> timeline){
		this.timeline = timeline;
	}
	
	public void addTimeline(Timeline t){
		Collection<Timeline> timeline = getTimeline();
		timeline.add(t);
	}
	
	public Collection<Push> getPush(){
		if(push ==null){
			push = new ArrayList<Push>();
		}
		return push;
	}
	
	public void setPush(Collection<Push> push){
		this.push = push;
	}
	
	public void addPush(Push p){
		Collection<Push> push = getPush();
		push.add(p);
	}
	
	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

}