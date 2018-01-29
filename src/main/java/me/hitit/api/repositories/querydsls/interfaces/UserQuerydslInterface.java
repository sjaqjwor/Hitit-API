package me.hitit.api.repositories.querydsls.interfaces;

import me.hitit.api.domains.User;

public interface UserQuerydslInterface {
	public User getUserByIdx(long idx);
	public User getUserByEmail(String email);
	public User getUserByPhoneNumber(String phoneNumber);
}