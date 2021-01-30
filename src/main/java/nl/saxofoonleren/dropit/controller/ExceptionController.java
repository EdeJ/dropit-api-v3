package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.exceptions.DemoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = DemoNotFoundException.class)
    public ResponseEntity<Object> exception(DemoNotFoundException exception) {
        System.out.println(exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }



}
