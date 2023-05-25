package com.example.taskbase.exception;

public class NotEnoughRight extends RuntimeException {

    public NotEnoughRight (String massage){
        super(massage);
    }
}
