package me.hitit.api.services;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.domains.User;
import me.hitit.api.dtos.UserDto;
import me.hitit.api.repositories.UserRepository;
import me.hitit.api.services.interfaces.UserServiceInterface;
import me.hitit.api.utils.encript.Encriptor;
import me.hitit.api.utils.res.Strings;

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
	public UserDto getUser(final String email, final String password) {
		LOG.debug("getUser");

		UserDto ud = ur.getUserByEmailAndPassword(email, password);
		if (ud == null) {
			return null;
		} else {
			return ud;
		}
	}

	@Override
	public Boolean getUserByEmail(final String email) {
		LOG.debug("getUser");

		UserDto ud = ur.getUserByEmail(email);
		if (ud == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean getUserByPhoneNumber(final String phoneNumber) {
		LOG.debug("getUser");

		UserDto ud = ur.getUserByPhoneNumber(phoneNumber);
		if (ud == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<UserDto> findAll() {
		LOG.debug("findAll");
		return null;
		// return ur.getAllUsers();
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
	public Map<Integer, Object> addUser(final SignUpForm suf) throws NoSuchAlgorithmException {
		LOG.debug("addUser");

		Map<Integer, Object> map = new HashMap<>();
		if (isPhoneNumberExist(suf.getPhoneNumber())) {
			map.put(1, Strings.ALREADY_EXIST_EMAIL);
			return map;
		}
		if (isEmailExist(suf.getEmail())) {
			map.put(1, Strings.ALREADY_EXIST_PHONE_NUMBER);
			return map;
		}
		User u = User.addUser(suf, Encriptor.sha256(suf.getPassword()));
		ur.save(u);
		map.put(0, UserDto.getUserDto(u));
		return map;
	}

	@Override
	public UserDto updateUser(final Long uidx, final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
		LOG.debug("updateUser");

		User u = ur.getUserByIdx(uidx);
		if (u == null) {
			return null;
		} else {
			String password = Encriptor.sha256(uupf.getPassword());
			u.setPassword(password);
			ur.save(u);
			return UserDto.getUserDto(u);
		}
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