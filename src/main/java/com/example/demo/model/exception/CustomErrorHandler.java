package com.example.demo.model.exception;



import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * This class handle all global exception
 */
//@ControllerAdvice
@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class CustomErrorHandler extends ResponseEntityExceptionHandler {
    MessageSource messageSource;
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ApiResponse errorResponse = ApiResponse.builder()
                .status(status.value())
                .message(messageSource.getMessage("validation.error", null, Locale.US))
                .errors(getErrors(ex))
                .build();
        log.error("[CustomErrorHandler.handleMethodArgumentNotValid] : error response {}", errorResponse);
        return new ResponseEntity<>(errorResponse, headers, status);
    }

    /**
     * handle if invoice list is null
     */
    @ExceptionHandler({RecordNotFoundException.class})
    public final ResponseEntity<Object> handleUserNotFound(Exception ex, WebRequest request) {
        ApiResponse errorResponse = ApiResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .errors(Arrays.asList(ex.getLocalizedMessage()))
                .build();
        log.error("[CustomErrorHandler.handleAllExceptions] : error response {}", errorResponse);
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }

    private List<String> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }

    
}
