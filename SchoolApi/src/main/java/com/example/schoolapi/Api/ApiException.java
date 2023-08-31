package com.example.schoolapi.Api;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
