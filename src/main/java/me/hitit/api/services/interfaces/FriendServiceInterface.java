package me.hitit.api.services.interfaces;

import me.hitit.api.domains.Friend;

/**
 * FriendService interface.
 *
 * @author cheoljin_k
 */
public interface FriendServiceInterface {

	/**
	 * Methods to insert friend.
	 *
	 * @param f
	 */
	public void addFriend(final Friend f);
}
