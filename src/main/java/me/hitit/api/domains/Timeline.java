package me.hitit.api.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "uidx")
    @JsonIgnore
    private User user;

    @Embedded
    private Coordinates coordinates;

    @Column(name = "openRange")
    private OpenRange openRange;

    @Column(name = "contents", columnDefinition = "TEXT")
    private String contents;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
    private Collection<TimelineComment> timelineComments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
    private Collection<TimelineImage> timelineImages;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
    private TimelineMusic timelineMusics;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
    private Collection<Tag> tags;

    @Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ts;

    public enum OpenRange {
        PRIVATE, FRIENDS, PUBLIC
    }
}
