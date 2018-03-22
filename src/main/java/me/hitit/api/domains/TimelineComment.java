package me.hitit.api.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimelineComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "tidx")
    @JsonIgnore
    private Timeline timeline;

    @ManyToOne
    @JoinColumn(name = "uidx")
    @JsonIgnore
    private User user;

    @Column(name = "contents", columnDefinition = "TEXT")
    private String contents;

    @Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ts;
}
