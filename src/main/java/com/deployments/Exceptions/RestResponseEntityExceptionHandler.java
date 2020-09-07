package com.deployments.Exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Object> handleConflict1(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This is internal server error"+ex;
        //return handleExceptionInternal(ex, bodyOfResponse,
               // new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyOfResponse);
    }

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleIllegalArgumentException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleDataIntegrtityException(RuntimeException ex){
        String bodyOdResponse = ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(bodyOdResponse);
    }

    @ExceptionHandler(value
            = { PatientIdNotFoundException.class })
    protected ResponseEntity<Object> handlePatientNotFoundException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        //return handleExceptionInternal(ex, bodyOfResponse,
        // new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
    }

    @ExceptionHandler(value={IdNotValidException.class})
    protected ResponseEntity<Object> handleInvalidPatientId(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(value
            = { SQLException.class, DataAccessException.class })
    protected ResponseEntity<Object> handleSQLException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        //return handleExceptionInternal(ex, bodyOfResponse,
        // new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyOfResponse);
    }
}
