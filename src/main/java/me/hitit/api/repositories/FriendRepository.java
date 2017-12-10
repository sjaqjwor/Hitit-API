package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Friend;

/**
 * FriendRepository interface.
 *
 * @author cheoljin_k
 */
@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

}
