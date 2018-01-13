package me.hitit.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;

/**
 * UserRepository interface.
 *
 * @author devetude
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>,UserQuerydslInterface {
/**
	 * Methods to get a user by email.
	 *
	 * @param email
	 * @return
	 */
	@Query("SELECT u FROM User AS u WHERE u.email = :email")
	public User getUserByEmail(final String email);

	/**
	 * Methods to get a user by email and password.
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	@Query("SELECT u FROM User AS u WHERE u.email = :email AND u.password = :password")
	public User getUserByEmailNPassword(final String email, final String password);

	/**
	 * Methods to get all users.
	 *
	 * @return
	 */
	@Query("SELECT u FROM User AS u")
	public List<User> getAllUsers();

	/**
	 * Methods to get user by phone number.
	 * 
	 * @param phoneNumber
	 * @return
	 */
	@Query("SELECT u FROM User AS u WHERE u.phoneNumber = :phoneNumber")
	public User getUserByPhoneNumber(final String phoneNumber);
}