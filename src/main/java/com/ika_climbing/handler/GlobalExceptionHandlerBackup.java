package com.ika_climbing.handler;

import com.ika_climbing.exceptions.ClientCreationException;
import com.ika_climbing.exceptions.ClientNotFoundException;
import com.ika_climbing.exceptions.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandlerBackup {

    /*@Autowired
    private HttpServletRequest request;

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerClientNotFoundException(ClientNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        errorResponse.setErrorMessage("User not Found");
        errorResponse.setErrorDetails(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setUrl(request.getRequestURL().toString());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public ResponseEntity<ErrorResponse> handlerNumberFormatException(NumberFormatException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setErrorMessage("Invalid ID format");
        errorResponse.setErrorDetails(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setUrl(request.getRequestURL().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ClientCreationException.class)
    public ResponseEntity<ErrorResponse> handlerUserCreationException(ClientCreationException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setErrorMessage("Failed to create user");
        errorResponse.setErrorDetails(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setUrl(request.getRequestURL().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }*/

}
