package me.hitit.api.services;

import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.domains.User;
import me.hitit.api.exceptions.user.UserConflictException;
import me.hitit.api.exceptions.user.UserNotFoundException;
import me.hitit.api.repositories.UserRepository;
import me.hitit.api.services.interfaces.UserServiceInterface;
import me.hitit.api.utils.encript.Encryptor;
import me.hitit.api.utils.res.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service("UserService")
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository ur;

    @Override
    public User getUser(long idx) {
        return Optional.ofNullable(ur.getUserByIdx(idx)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getUser(String email, String password) {
        return Optional.ofNullable(ur.getUserByEmailAndPassword(email, password)).orElseThrow(UserNotFoundException::new);
    }


    @Override
    public Boolean isEmailExist(String email) {
        return ur.getUserByEmail(email) != null;
    }

    @Override
    public void addUser(SignUpForm suf) throws NoSuchAlgorithmException {
        if (isPhoneNumberExist(suf.getPhoneNumber())) {
            throw new UserConflictException(Strings.ALREADY_EXIST_PHONE_NUMBER);
        }
        if (isEmailExist(suf.getEmail())) {
            throw new UserConflictException(Strings.ALREADY_EXIST_EMAIL);
        }
        User u = User.builder()
                .name(suf.getName())
                .password(Encryptor.sha256(suf.getPassword()))
                .phoneNumber(suf.getPhoneNumber())
                .email(suf.getEmail())
                .build();
        ur.save(u);
    }

    @Override
    public User updateUser(Long uidx, UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
        User u = Optional.ofNullable(ur.getUserByIdx(uidx)).orElseThrow(UserNotFoundException::new);
        String password = Encryptor.sha256(uupf.getPassword());
        u.setPassword(password);
        ur.save(u);
        return u;
    }

    @Override
    public Boolean isPhoneNumberExist(String phoneNumber) {
        return ur.getUserByPhoneNumber(phoneNumber) != null;
    }
}
