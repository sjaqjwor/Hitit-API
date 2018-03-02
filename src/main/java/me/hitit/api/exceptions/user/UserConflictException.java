package me.hitit.api.exceptions.user;

import org.apache.log4j.Logger;

public class UserConflictException extends RuntimeException{
    private static final Logger LOG = Logger.getLogger(UserConflictException.class);

    public UserConflictException(String msg){
        super(msg);
    }
}
