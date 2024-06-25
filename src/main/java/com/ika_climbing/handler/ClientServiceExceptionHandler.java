package com.ika_climbing.handler;

import com.ika_climbing.dto.APIResponse;
import com.ika_climbing.exceptions.ClientNotFoundException;
import com.ika_climbing.exceptions.ClientServiceBusinessException;
import com.ika_climbing.exceptions.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ClientServiceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception){
        APIResponse<?> response = new APIResponse<>();
        List<ErrorResponse> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorResponse errorResponse = new ErrorResponse(error.getField(), error.getDefaultMessage());
                    errors.add(errorResponse);
                });
        response.setStatus("FAILED");
        response.setErrors(errors);
        return response;
    }

    @ExceptionHandler(ClientServiceBusinessException.class)
    public APIResponse<?> handleClientServiceException(ClientServiceBusinessException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorResponse("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<APIResponse<?>> handleClientNotFoundException(ClientNotFoundException ex) {
        log.error("Client not found, Exception message: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("", ex.getMessage());
        APIResponse<?> apiResponse = APIResponse.<ErrorResponse>builder()
                .status("FAILED")
                .errors(Collections.singletonList(errorResponse))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

}
