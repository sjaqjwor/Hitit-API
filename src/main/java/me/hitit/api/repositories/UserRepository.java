package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;

/**
 * UserRepository interface.
 *
 * @author devetude
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserQuerydslInterface {

}