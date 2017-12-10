package me.hitit.api.services.interfaces;

import java.util.List;

import me.hitit.api.domains.User;

/**
 * UserService interface.
 *
 * @author devetude
 */
public interface UserServiceInterface {
	/**
	 * Methods to get a user by index.
	 */
	public User getUser(final long idx);

	/**
	 * Methods to get a user by email and password.
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	public User getUser(final String email, final String password);

	/**
	 * Methods to get a user by email.
	 *
	 * @param email
	 * @return
	 */
	public User getUser(final String email);

	/**
	 * Methods to get all users.
	 *
	 * @param email
	 * @return
	 */
	public List<User> findAll();

	/**
	 * Methods to check email exist.
	 *
	 * @param email
	 * @return
	 */
	public boolean isEmailExist(final String email);

	/**
	 * Methods to user entity to check existence by index.
	 *
	 * @param idx
	 * @return
	 */
	public boolean isUserExist(final long idx);

	/**
	 * Methods to insert user.
	 *
	 * @param u
	 */
	public void addUser(final User u);

	/**
	 * Methods to update user.
	 *
	 * @param u
	 */
	public void updateUser(final User u);

	/**
	 * Methods to delete user.
	 *
	 * @param idx
	 */
	public void deleteUser(final long idx);

	/**
	 * Methods to check phone number exist.
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean isPhoneNumberExist(final String phoneNumber);
}