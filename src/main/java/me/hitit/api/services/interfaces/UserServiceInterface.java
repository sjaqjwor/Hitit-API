package me.hitit.api.services.interfaces;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.domains.User;
import me.hitit.api.dtos.UserDto;

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
	public UserDto getUser(final String email, final String password);

	/**
	 * Methods to get a user by email.
	 *
	 * @param email
	 * @return
	 */
	public Boolean getUserByPhoneNumber(final String phoneNumber);

	/**
	 * Methods to get a user by phonenumber.
	 *
	 * @param email
	 * @return
	 */
	public Boolean getUserByEmail(final String email);

	/**
	 * Methods to get all users.
	 *
	 * @param email
	 * @return
	 */
	public List<UserDto> findAll();

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
	 * @param SignUpForm
	 */
	public Map<Integer, Object> addUser(final SignUpForm suf) throws NoSuchAlgorithmException;

	/**
	 * Methods to update user.
	 *
	 * @param UpdateUserPasswordForm
	 * @param uidx
	 */
	public UserDto updateUser(final Long uidx, final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException;

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