package me.hitit.api.repositories.querydsls.interfaces;

import me.hitit.api.domains.User;

public interface UserQuerydslInterface {
    User getUserByIdx(Long idx);

    User getUserByEmail(String email);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserByEmailAndPassword(String email, String password);
}
