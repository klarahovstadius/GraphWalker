package springcourse.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
     * If we send a GET request for a URI that doesn't exist or other errors happens, we want to control the output
     * With this, we will get an output with "timestamp, message, details" + 500 error, when an exception happens
     * These details are specified in my class ExceptionResponse (the bean)
     * Inside the extended class, a similar method to handleAllException exists, but we want to override it
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * For some other types of error, we want another error message
     * Without this whole class, the UserNotFoundException class would give me the 404 not found status
     * Having this class but not having the method below would give me a 500 status (since we have the method above that controls all exceptions and sends a 500 status)
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Override a method that throws an exception when we enter something invalid (we are controlling what counts as valid input in some of the post mapping methods)
     * Without this method, we wouldn't get any information about what went wrong when we send in invalid input, we would only get the status bad request back
     * ex.getBindingResult().toString() will give us some more details about the error
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation failed", ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
