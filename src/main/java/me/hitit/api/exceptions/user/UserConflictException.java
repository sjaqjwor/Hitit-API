package me.hitit.api.exceptions.user;

public class UserConflictException extends RuntimeException {
    public UserConflictException(String msg) {
        super(msg);
    }
}
