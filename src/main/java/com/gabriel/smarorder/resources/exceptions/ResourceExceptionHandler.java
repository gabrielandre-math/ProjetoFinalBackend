package com.gabriel.smarorder.resources.exceptions;

import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(
                ex.getMessage(), request.getRequestURI(), "Object not found",
                HttpStatus.NOT_FOUND.value(), System.currentTimeMillis()
              );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}

