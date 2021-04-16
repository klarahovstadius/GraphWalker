package springcourse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

/**
 * @RestController --> will run this class when running the application
 * We will create and retrieve users, with the help of the UserDoService class
 */
@RestController
public class UserController {

    //Create an instance of UserDaoService
    @Autowired
    private UserDaoService service; //bean

    //retrieve all users
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    /**
     * Retrieve a specific user - remember to add @PathVariable
     * It's the id I enter in the browser that will be passed/used in this method
     */
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user==null)
            throw  new UserNotFoundException("id-"+id); //without this, it will return 200 OK even if the user doesn't exist
        return user;
    }

    /**
     * Create a user - send in name and birthdate and let the backend set the id
     * We send the post request via Postman and I think it goes into this method, assigns an id to the user via service.save(user)
     *
     * @RequestBody: the HttpRequest I send that is sent in, matching the path, will be mapped to the Java object "user"
     */
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = service.save(user); //we are assigning an id inside the method "save" and add the user to the list
        //Servlet... is used to determine the location for the line below, ResponseEntity
        // /user/{id} is the new user. Replace {id} with savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}") //to amend {id}
                .buildAndExpand(savedUser.getId()).toUri(); //what to replace "path" with
        return ResponseEntity.created(location).build(); //return how it went
    }
}