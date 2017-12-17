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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User class.
 *
 * @author devetude, cheoljin_k
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Device device;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<Timeline> timeline;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<Push> push;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public Collection<Timeline> getTimeline() {
		if (timeline == null) {
			timeline = new ArrayList<Timeline>();
		}
		return timeline;
	}

	public void setTimeline(Collection<Timeline> timeline) {
		this.timeline = timeline;
	}

	public void addTimeline(Timeline t) {
		Collection<Timeline> timeline = getTimeline();
		timeline.add(t);
	}

	public Collection<Push> getPush() {
		if (push == null) {
			push = new ArrayList<Push>();
		}
		return push;
	}

	public void setPush(Collection<Push> push) {
		this.push = push;
	}

	public void addPush(Push p) {
		Collection<Push> push = getPush();
		push.add(p);
	}
}