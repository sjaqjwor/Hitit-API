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
import me.hitit.api.utils.encript.Encriptor;
import me.hitit.api.utils.res.Strings;
import org.apache.log4j.Logger;
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
    private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());

    @Autowired
    private UserService us;

    @GetMapping("user/{uidx}")
    @Auth
    public @ResponseBody
    ResponseEntity<DefaultResponse> getUser(@RequestHeader("Authorization") String jwt,
                                            @PathVariable("uidx") final Long uidx) {
        User u = us.getUser(uidx);
        UserResponseData urd = UserResponseData.builder().idx(u.getIdx()).email(u.getEmail()).name(u.getName()).profileImageKey(u.getProfileImageKey()).build();
        GetUserResponseData gurd = GetUserResponseData.builder().userResponseData(urd).build();
        return new ResponseEntity<>(new DefaultResponse(gurd), HttpStatus.OK);
    }

    @GetMapping("user/check/email/{email:.+}")
    @Auth
    public @ResponseBody
    ResponseEntity<DefaultResponse> checkEmail(@RequestHeader("Authorization") String jwt,@PathVariable("email") final String email) {
        Boolean exist = us.isEmailExist(email);
        CheckEmailResponseData cerd = CheckEmailResponseData.builder().exist(exist).build();
        return new ResponseEntity<>(new DefaultResponse(cerd), HttpStatus.OK);
    }

    @GetMapping("user/check/phoneNumber/{phoneNumber}")
    @Auth
    public @ResponseBody
    ResponseEntity<DefaultResponse> checkPhoneNumber(@RequestHeader("Authorization") String jwt,
            @PathVariable("phoneNumber") final String phoneNumber) {
        Boolean exist = us.isPhoneNumberExist(phoneNumber);
        CheckPhoneNumberResponseData cpnrd = CheckPhoneNumberResponseData.builder().exist(exist).build();
        return new ResponseEntity<>(new DefaultResponse(cpnrd), HttpStatus.OK);
    }

    @PostMapping("user/sign/up")
    public @ResponseBody
    ResponseEntity<DefaultResponse> signUp(@Valid @RequestBody final SignUpForm suf)
            throws NoSuchAlgorithmException {
        // Use password encryption method done
        us.addUser(suf);
        return new ResponseEntity<>(new DefaultResponse(Status.SUCCESS), HttpStatus.OK);
    }

    @PostMapping("user/sign/in")
    public @ResponseBody
    ResponseEntity<DefaultResponse> signIn(@Valid @RequestBody final SignInForm sif)
            throws NoSuchAlgorithmException {
        User u = us.getUser(sif.getEmail(), Encriptor.sha256(sif.getPassword()));
        UserResponseData urd = UserResponseData.builder().idx(u.getIdx()).email(u.getEmail()).name(u.getName()).profileImageKey(u.getProfileImageKey()).build();
        GetUserSignInResponseData usird = GetUserSignInResponseData.builder().token(JWT.create(urd.getIdx())).userResponseData(urd).build();
        return new ResponseEntity<>(new DefaultResponse(usird), HttpStatus.OK);
    }

    @PutMapping("user/{uidx}")
    @Auth
    public @ResponseBody
    ResponseEntity<DefaultResponse> updateUserPassword(
            @Valid @RequestHeader("Authorization") String jwt, @PathVariable("uidx") final Long uidx,
            @RequestBody final UpdateUserPasswordForm uupf) throws NoSuchAlgorithmException {
        User u = us.updateUser(uidx, uupf);
        UserResponseData urd = UserResponseData.builder().idx(u.getIdx()).email(u.getEmail()).name(u.getName()).profileImageKey(u.getProfileImageKey()).build();
        GetUserResponseData gurd = GetUserResponseData.builder().userResponseData(urd).build();
        return new ResponseEntity<>(new DefaultResponse(gurd), HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<?> handleStorageFileNotFound(NoSuchAlgorithmException nsae) {
        DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ALGORITHM);
        return new ResponseEntity<>(dr, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DefaultResponse> userNotFoundExceptionHandler(UserNotFoundException unfe) {
        return new ResponseEntity<>(new DefaultResponse(Status.NOT_FOUND, Strings.CAN_NOT_FOUND_USER), HttpStatus.OK);
    }

    @ExceptionHandler(UserConflictException.class)
    public ResponseEntity<?> userConflictException(UserConflictException uce) {
        return new ResponseEntity<>(new DefaultResponse(Status.CONFLICT, uce.getMessage()), HttpStatus.OK);
    }

}