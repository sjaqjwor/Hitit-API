package me.hitit.api.services;

import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.UserRepository;
import me.hitit.api.services.interfaces.UserServiceInterface;
import me.hitit.api.utils.encript.Encriptor;
import me.hitit.api.utils.res.Strings;
import me.hitit.api.view_objects.GetUserViewObject;
import me.hitit.api.view_objects.SignUpViewObject;
import me.hitit.api.view_objects.UpdateUserViewObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;



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

        User u = ur.getUserByIdx(idx);
        if (u == null) {
            return null;
        } else {
            return u;
        }
    }

    @Override
    public GetUserViewObject getUser(final String email, final String password) {
        LOG.debug("getUser");

        User u = ur.getUserByEmailAndPassword(email, password);
        if (u == null) {
            return GetUserViewObject.getCreate(u);
        } else {
            return GetUserViewObject.getCreate(u);
        }
    }


    @Override
    public Boolean isEmailExist(final String email) {
        LOG.debug("isUserExist");

        return ur.getUserByEmail(email) != null;
    }

    @Override
    public SignUpViewObject addUser(final SignUpForm suf) throws NoSuchAlgorithmException {
        LOG.debug("addUser");

        if (isPhoneNumberExist(suf.getPhoneNumber())) {
            return new SignUpViewObject(Status.CONFLICT, Strings.ALREADY_EXIST_PHONE_NUMBER, false);
        }
        if (isEmailExist(suf.getEmail())) {
            return new SignUpViewObject(Status.CONFLICT, Strings.ALREADY_EXIST_EMAIL, false);
        }
        User u = User.addUser(suf, Encriptor.sha256(suf.getPassword()));
        ur.save(u);
        return new SignUpViewObject(Status.SUCCESS, null, true);
    }

    @Override
    public UpdateUserViewObject updateUser(final Long uidx, final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
        LOG.debug("updateUser");

        User u = ur.getUserByIdx(uidx);
        if (u == null) {
            return UpdateUserViewObject.ofCreate(u);
        } else {
            String password = Encriptor.sha256(uupf.getPassword());
            u.setPassword(password);
            ur.save(u);
            return UpdateUserViewObject.ofCreate(u);
        }
    }
//	@Override
//	public void deleteUser(final long idx) {
//		LOG.debug("deleteUser");
//
//		ur.delete(idx);
//	}
//
    @Override
    public Boolean isPhoneNumberExist(final String phoneNumber) {
        return ur.getUserByPhoneNumber(phoneNumber) != null;
    }
}