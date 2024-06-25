package com.ika_climbing.exceptions;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id){
        super("Could not found the Client with ID: " + id);
    }
}
