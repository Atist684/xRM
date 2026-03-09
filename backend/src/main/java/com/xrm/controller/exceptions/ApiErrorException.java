package com.xrm.controller.exceptions;

//TODO:: Custom business logic
public class ApiErrorException extends RuntimeException {

    public ApiErrorException(String msg){
        super(msg);
    }
    
}
