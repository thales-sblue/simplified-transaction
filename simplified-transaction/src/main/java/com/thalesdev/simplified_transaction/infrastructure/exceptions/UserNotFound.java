package com.thalesdev.simplified_transaction.infrastructure.exceptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String message){
        super(message);
    }
}
