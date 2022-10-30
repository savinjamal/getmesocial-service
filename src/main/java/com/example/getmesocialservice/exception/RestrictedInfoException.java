package com.example.getmesocialservice.exception;

public class RestrictedInfoException extends Exception{

    @Override
    public String getMessage(){
        return "Root is not allowed";
    }
}

