package com.hemant.exceptionHandlers;

import com.hemant.exceptions.BusException;
import com.hemant.exceptions.ReservationException;
import com.hemant.exceptions.RouteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(RouteException.class)
    public ResponseEntity<ErrorDetails> routeExceptionHandler(RouteException se, WebRequest req)
    {
        ErrorDetails ed = new ErrorDetails();
        ed.setTimestamp(LocalDateTime.now());
        ed.setMessage(se.getMessage());
        ed.setDetails(req.getDescription(false));

        return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusException.class)
    public ResponseEntity<ErrorDetails> busExceptionHandler(BusException se,WebRequest req)
    {
        ErrorDetails ed = new ErrorDetails();
        ed.setTimestamp(LocalDateTime.now());
        ed.setMessage(se.getMessage());
        ed.setDetails(req.getDescription(false));

        return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<ErrorDetails> reservationExceptionHandler(ReservationException se,WebRequest req)
    {
        ErrorDetails ed = new ErrorDetails();
        ed.setTimestamp(LocalDateTime.now());
        ed.setMessage(se.getMessage());
        ed.setDetails(req.getDescription(false));

        return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
    }
}
