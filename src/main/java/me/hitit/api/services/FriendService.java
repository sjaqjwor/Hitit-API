package me.hitit.api.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hitit.api.domains.Friend;
import me.hitit.api.repositories.FriendRepository;
import me.hitit.api.services.interfaces.FriendServiceInterface;

/**
 * FriendService class.
 *
 * @author cheoljin_k
 */
@Service("FriendService")
public class FriendService implements FriendServiceInterface {
	private static final Logger LOG = Logger.getLogger(FriendService.class.getSimpleName());

	@Autowired
	private FriendRepository fr;


	@Override
	public void addFriend(final Friend f) {
		LOG.debug("addFriend");

		fr.save(f);
	}
}
