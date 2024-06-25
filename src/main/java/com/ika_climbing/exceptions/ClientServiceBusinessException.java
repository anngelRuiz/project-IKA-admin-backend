package com.ika_climbing.exceptions;

public class ClientServiceBusinessException extends RuntimeException{

    public ClientServiceBusinessException(String message){
        super(message);
    }
}
