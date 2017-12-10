package me.hitit.api.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hitit.api.domains.User;
import me.hitit.api.repositories.UserRepository;
import me.hitit.api.services.interfaces.UserServiceInterface;

/**
 * UserService class.
 *
 * @author devetude, cheoljin_k
 */
@Service("UserService")
public class UserService implements UserServiceInterface {
	private static final Logger LOG = Logger.getLogger(UserService.class.getSimpleName());

	@Autowired
	private UserRepository ur;

	@Override
	public User getUser(final long idx) {
		LOG.debug("getUser");

		return ur.getUserByIdx(idx);
	}

	@Override
	public User getUser(final String email, final String password) {
		LOG.debug("getUser");

		return ur.getUserByEmailNPassword(email, password);
	}

	@Override
	public User getUser(final String email) {
		LOG.debug("getUser");

		return ur.getUserByEmail(email);
	}

	@Override
	public List<User> findAll() {
		LOG.debug("findAll");

		return ur.getAllUsers();
	}

	@Override
	public boolean isEmailExist(final String email) {
		LOG.debug("isUserExist");

		return ur.getUserByEmail(email) != null;
	}

	@Override
	public boolean isUserExist(final long idx) {
		LOG.debug("isUserExist");

		return ur.getUserByIdx(idx) != null;
	}

	@Override
	public void addUser(final User u) {
		LOG.debug("addUser");

		ur.save(u);
	}

	@Override
	public void updateUser(final User u) {
		LOG.debug("updateUser");

		ur.save(u);
	}

	@Override
	public void deleteUser(final long idx) {
		LOG.debug("deleteUser");

		ur.delete(idx);
	}

	@Override
	public boolean isPhoneNumberExist(final String phoneNumber) {
		return ur.getUserByPhoneNumber(phoneNumber) != null;
	}
}