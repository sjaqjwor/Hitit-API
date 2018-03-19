package me.hitit.api.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Push {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "uidx")
    @JsonIgnore
    private User user;

    @Column(name = "type")
    private Type type;

    @Column(name = "payload", columnDefinition = "TEXT")
    private String payload;

    @Column(name = "isRead")
    private Boolean isRead;

    @Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ts;

    public enum Status {
        FAIL, SUCCESS
    }

    public enum Type {
        UPDATE_TIMELINE, ADD_TIMELINE_COMMENT, ADD_MESSAGE
    }
}
