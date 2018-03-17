package me.hitit.api.services.interfaces;

import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.domains.User;

import java.security.NoSuchAlgorithmException;

public interface UserServiceInterface {
    User getUser(final long idx);

    User getUser(final String email, final String password);

    Boolean isEmailExist(final String email);

    void addUser(final SignUpForm suf) throws NoSuchAlgorithmException;

    User updateUser(final Long uidx, final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException;

    Boolean isPhoneNumberExist(final String phoneNumber);
}
