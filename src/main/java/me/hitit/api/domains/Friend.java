package me.hitit.api.domains;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.pks.FriendPK;

/**
 * Friend class.
 *
 * @author cheoljin_k
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Friend {
	private static final Logger LOG = Logger.getLogger(Friend.class.getSimpleName());

	@EmbeddedId
	private FriendPK friendPk;

}
