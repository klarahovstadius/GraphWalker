package springcourse.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * We need to define an exception structure for ambiguous responses
 * Without this, it could return 200 OK even if the search item doesn't exist
 */
@ResponseStatus(HttpStatus.NOT_FOUND) //when entering this exception, send a specific response
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
