package com.epam.second.task.jmpcloudserviceimpl.excpetion;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User not found with id " + userId);
    }

}
