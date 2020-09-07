package com.deployments.Exceptions;


//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class PatientIdNotFoundException extends RuntimeException {
        public PatientIdNotFoundException() {
            super();
        }
        public PatientIdNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
        public PatientIdNotFoundException(String message) {
            super(message);
        }
        public PatientIdNotFoundException(Throwable cause) {
            super(cause);
        }
    }

