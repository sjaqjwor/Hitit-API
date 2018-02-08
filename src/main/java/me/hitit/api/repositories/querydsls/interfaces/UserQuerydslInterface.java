package me.hitit.api.repositories.querydsls.interfaces;

import java.util.List;

import me.hitit.api.domains.User;
import me.hitit.api.dtos.UserDto;

public interface UserQuerydslInterface {
	public User getUserByIdx(Long idx);
	public UserDto getUserByEmail(String email);
	public UserDto getUserByPhoneNumber(String phoneNumber);
	public UserDto getUserByEmailAndPassword(String email, String password);
	public List<UserDto> getAllUsers(Long page, String sort, String standard);
}