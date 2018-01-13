package me.hitit.api.domains;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.primary_keys.FriendPrimaryKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Friend {
	@EmbeddedId
	private FriendPrimaryKey friendPk;

	@Column(name="checkBen")
	private boolean checkBlock;
}