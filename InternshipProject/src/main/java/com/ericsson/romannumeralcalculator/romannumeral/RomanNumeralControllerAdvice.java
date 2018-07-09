package com.ericsson.romannumeralcalculator.romannumeral;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ericsson.romannumeralcalculator.exceptions.ValidationException;

/**
 * @author ekvumer
 *
 *         Class to handle any exceptions that may be thrown in this application
 *
 */

@ControllerAdvice
public class RomanNumeralControllerAdvice {

    /**
     * Exception handler for validation exception
     *
     * @return returns a ResponseEntity object to inform the user of the bad request that has been made
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationError() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * General exception handler
     *
     * @return returns a ResponseEntity object with a 500 error code
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnexpectedError() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
