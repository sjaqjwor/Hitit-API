package me.hitit.api.services;

import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.UserRepository;
import me.hitit.api.utils.encript.Encriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService us;
    @Autowired
    private UserRepository ur;
    @Value("${test.user.password}")
    private String password;

    @Test
    public void getUser() {
        User u = new User();
        u.setIdx(new Long(0));
        User u1 = Optional.ofNullable(ur.getUserByIdx(new Long(18))).orElse(u);
        assertThat(us.getUser(new Long(18)).getIdx(), is(u1.getIdx()));
        assertThat(us.getUser(new Long(18)).getName(), is(u1.getName()));
        assertThat(us.getUser(new Long(18)).getPhoneNumber(), is(u1.getPhoneNumber()));
        assertThat(us.getUser(new Long(18)).getEmail(), is(u1.getEmail()));
    }

    @Test
    public void getUserEmailAndPassword() throws NoSuchAlgorithmException {
        User u = new User();
        u.setIdx(new Long(0));
        password = Encriptor.sha256(password);
        User u1 = Optional.ofNullable(ur.getUserByEmailAndPassword("seungki1993@naver.com", password)).orElse(u);
        assertThat(us.getUser("seungki1993@naver.com", password).getIdx(), is(u1.getIdx()));
        assertThat(us.getUser("seungki1993@naver.com", password).getEmail(), is(u1.getEmail()));
        assertThat(us.getUser("seungki1993@naver.com", password).getProfileImageKey(), is(u1.getProfileImageKey()));
        assertThat(us.getUser("seungki1993@naver.com", password).getName(), is(u1.getName()));
        assertThat(us.getUser("seungki1993@naver.com", password).getPhoneNumber(), is(u1.getPhoneNumber()));
    }

    @Test
    public void isEmailExist() {
        User u = ur.getUserByEmail("seungki1993@naver.com");
        Boolean exist = u == null ? false : true;
        assertThat(us.isEmailExist("seungki1993@naver.com"), is(exist));
        assertThat(us.isEmailExist("temp"), is(exist));
    }

    @Test
    public void isPhoneNumberExist() {
        User u = ur.getUserByPhoneNumber("01091476976");
        Boolean exist = u == null ? false : true;
        assertThat(us.isPhoneNumberExist("01091476976"), is(exist));
        assertThat(us.isPhoneNumberExist("0109"), is(exist));
    }

    @Test
    public void addUser() throws NoSuchAlgorithmException {
        SignUpForm suf = new SignUpForm();
        suf.setEmail("dami11");
        suf.setName("dami");
        suf.setPhoneNumber("01062926120");
        suf.setPassword("1");
        us.addUser(suf);
    }

    @Test
    public void updateUser() throws NoSuchAlgorithmException {
        User u = ur.getUserByIdx(new Long(0));
        User u1 = ur.getUserByIdx(new Long(26));
        UpdateUserPasswordForm uupf = new UpdateUserPasswordForm();
        uupf.setPassword("12");

        User temp = us.updateUser(new Long(0), uupf);
        assertThat(temp.getIdx(), is(u.getIdx()));
        assertThat(temp.getEmail(), is(u.getEmail()));
        assertThat(temp.getName(), is(u.getName()));
        assertThat(temp.getProfileImageKey(), is(u.getProfileImageKey()));
        User temp1 = us.updateUser(new Long(26), uupf);
        assertThat(temp1.getIdx(), is(u1.getIdx()));
        assertThat(temp1.getEmail(), is(u1.getEmail()));
        assertThat(temp1.getName(), is(u1.getName()));
        assertThat(temp1.getProfileImageKey(), is(u1.getProfileImageKey()));
    }

}
