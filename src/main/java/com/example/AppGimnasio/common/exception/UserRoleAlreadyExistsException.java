package com.example.AppGimnasio.common.exception;

public class UserRoleAlreadyExistsException extends RuntimeException {
    public UserRoleAlreadyExistsException(String message) {
        super(message);
    }
}
