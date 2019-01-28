package com.stackroute.exceptions;
import com.stackroute.domain.Track;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;

//creating global exceptions with already defined exception classes
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity trackAlreadyExistsException(final TrackAlreadyExistsException exc) {
        return new ResponseEntity(exc.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity trackNotFoundException(final TrackAlreadyExistsException exc){
        return new ResponseEntity(exc.getMessage(),HttpStatus.NOT_FOUND);
    }


}
