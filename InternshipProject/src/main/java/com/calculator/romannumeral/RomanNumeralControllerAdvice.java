package com.calculator.romannumeral;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.calculator.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author ekvumer
 *      Class to handle any excpetions that may be thrown in this application
 *
 */

@ControllerAdvice
public class RomanNumeralControllerAdvice {
   
    /**
     * @return
     *  This handles return a ResponseEntity object to inform the user of the bad request that has been made
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationError() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
