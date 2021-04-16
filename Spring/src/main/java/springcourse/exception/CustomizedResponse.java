package springcourse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springcourse.user.UserNotFoundException;

import java.util.Date;

/**
 * @ControllerAdvice: Means that this should be applied to all controllers
 */
@ControllerAdvice
@RestController //since this is sending a response back
public class CustomizedResponse extends ResponseEntityExceptionHandler {
    /**
     * If we send a GET request for a URI that doesn't exist, we want to control the output
     * With this, we will get an output with "timestamp, message, details" + 500 error, when an exception happens
     * Inside the extended class, a similar method to handleAllException exists, but we want to override it
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * For some other types of error, we want another error message
     * In this case, we are just modifying the UserNotFoundException with sending "timestamp" etc.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
