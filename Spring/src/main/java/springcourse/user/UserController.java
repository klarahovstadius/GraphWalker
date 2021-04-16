package springcourse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @RestController --> will run this class when running the application
 * We will create and retrieve users (etc), with the help of the UserDoeService class
 */
@RestController
public class UserController {

    @Autowired //Create an instance of UserDaoService
    private UserDaoService service; //bean

    @GetMapping(path = "/users") //to get all users
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}") //get a specific user. It's the id I enter in the browser that will be passed to this method.
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user==null)
            throw  new UserNotFoundException("id-"+id+" not found"); //without this, it will return 200 OK even if the user doesn't exist
        return user;
    }

    @DeleteMapping(path = "/users/{id}") //delete a user (via Postman --> goes into this)
    public void deleteUser(@PathVariable int id) { //if nothing is returned, it went okay (200)
        User user = service.deleteById(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id); //without this, it will return 200 OK even if the user doesn't exist
    }

    /**
     * Create a user - send in name and birthdate via Postman and let the backend set the id
     * So we have this method to map it to the URI and to set the id (from the Postman post request)
     *
     * @Valid is validating the format of the input
     * @RequestBody: the HttpRequest I send that is sent in, matching the path, will be mapped to the Java object "user"
     */
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user); //we are assigning an id inside the method "save" and add the user to the list
        // /user/{id} is the new user. Replace {id} with savedUser.getId()
        URI location = ServletUriComponentsBuilder //Servlet... is used to determine the location for the line below, ResponseEntity
                .fromCurrentRequest()
                .path("/{id}") //to amend {id}
                .buildAndExpand(savedUser.getId()).toUri(); //what to replace "path" with
        return ResponseEntity.created(location).build(); //return how it went
    }


    /**
     * To add links to response as well (similar as to the basic/sufficient one called retrieveUser)
     */
    /*@GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id + " not found");
        //HATEOAS --> add links. If the link would change, it could control it.
        // Return a link for the users in the response
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = //to create a link for a method
                linkTo(methodOn(this.getClass()).retrieveAllUsers()); //create a link to the method retrieveAllUsers
        resource.add(linkTo.withRel("all-users")); //name to refer to this link is "all-users" (will be shown in the response in Postman: "links":"all-users":"http.../users")
        return resource; //return the user and links, instead of just the user
    }*/
}