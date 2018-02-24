package me.hitit.api.repositories.querydsls.interfaces;

import me.hitit.api.domains.User;

public interface UserQuerydslInterface {
	public User getUserByIdx(Long idx);
	public User getUserByEmail(String email);
	public User getUserByPhoneNumber(String phoneNumber);
	public User getUserByEmailAndPassword(String email, String password);
//	public List<UserDto> getAllUsers(Long page, String sort, String standard);
}