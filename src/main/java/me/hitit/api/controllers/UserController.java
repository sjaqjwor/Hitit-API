package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.controllers.responses.data.user.*;
import me.hitit.api.domains.User;
import me.hitit.api.exceptions.user.UserConflictException;
import me.hitit.api.exceptions.user.UserNotFoundException;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.auth.JWT;
import me.hitit.api.utils.encript.Encryptor;
import me.hitit.api.utils.res.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("")
@Api
public class UserController {
    @Autowired
    private UserService us;

    @GetMapping("user/{uidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getUser(
            @RequestHeader("Authorization") String jwt, @PathVariable("uidx") Long uidx) {
        User u = us.getUser(uidx);
        UserResponseData urd = UserResponseData.builder()
                .idx(u.getIdx())
                .email(u.getEmail())
                .name(u.getName())
                .profileImageKey(u.getProfileImageKey())
                .build();
        GetUserResponseData gurd = GetUserResponseData.builder()
                .userResponseData(urd)
                .build();
        return new ResponseEntity<>(new DefaultResponse(gurd), HttpStatus.OK);
    }

    @GetMapping("user/check/email/{email:.+}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> checkEmail(
            @RequestHeader("Authorization") String jwt, @PathVariable("email") String email) {
        CheckEmailResponseData cerd = CheckEmailResponseData.builder()
                .exist(us.isEmailExist(email))
                .build();
        return new ResponseEntity<>(new DefaultResponse(cerd), HttpStatus.OK);
    }

    @GetMapping("user/check/phoneNumber/{phoneNumber}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> checkPhoneNumber(
            @RequestHeader("Authorization") String jwt, @PathVariable("phoneNumber") String phoneNumber) {
        CheckPhoneNumberResponseData cpnrd = CheckPhoneNumberResponseData.builder()
                .exist(us.isPhoneNumberExist(phoneNumber))
                .build();
        return new ResponseEntity<>(new DefaultResponse(cpnrd), HttpStatus.OK);
    }

    @PostMapping("user/sign/up")
    @ResponseBody
    public ResponseEntity<DefaultResponse> signUp(@Valid @RequestBody SignUpForm suf) throws NoSuchAlgorithmException {
        us.addUser(suf);
        return new ResponseEntity<>(new DefaultResponse(Status.SUCCESS), HttpStatus.OK);
    }

    @PostMapping("user/sign/in")
    @ResponseBody
    public ResponseEntity<DefaultResponse> signIn(@Valid @RequestBody SignInForm sif)
            throws NoSuchAlgorithmException {
        User u = us.getUser(sif.getEmail(), Encryptor.sha256(sif.getPassword()));
        UserResponseData urd = UserResponseData.builder()
                .idx(u.getIdx())
                .email(u.getEmail())
                .name(u.getName())
                .profileImageKey(u.getProfileImageKey())
                .build();
        GetUserSignInResponseData gusr = GetUserSignInResponseData.builder()
                .token(JWT.create(urd.getIdx()))
                .userResponseData(urd)
                .build();
        return new ResponseEntity<>(new DefaultResponse(gusr), HttpStatus.OK);
    }

    @PutMapping("user/{uidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateUserPassword(
            @Valid @RequestHeader("Authorization") String jwt, @PathVariable("uidx") Long uidx,
            @RequestBody UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
        User u = us.updateUser(uidx, uupf);
        UserResponseData urd = UserResponseData.builder()
                .idx(u.getIdx())
                .email(u.getEmail())
                .name(u.getName())
                .profileImageKey(u.getProfileImageKey())
                .build();
        GetUserResponseData gurd = GetUserResponseData.builder()
                .userResponseData(urd)
                .build();
        return new ResponseEntity<>(new DefaultResponse(gurd), HttpStatus.OK);
    }
}
