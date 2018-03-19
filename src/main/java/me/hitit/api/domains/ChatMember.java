package me.hitit.api.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.primary_keys.ChatMemberPrimaryKey;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMember {
    @EmbeddedId
    private ChatMemberPrimaryKey chatMemberPk;

    @Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ts;

    @MapsId("chatId")
    @ManyToOne
    @JoinColumn(name = "cidx")
    @JsonIgnore
    private Chat chat;
}
