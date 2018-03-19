package me.hitit.api.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.primary_keys.FriendPrimaryKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Friend {
    @EmbeddedId
    private FriendPrimaryKey friendPk;

    @Column(name = "checkBlock")
    private Boolean checkBlock;
}
