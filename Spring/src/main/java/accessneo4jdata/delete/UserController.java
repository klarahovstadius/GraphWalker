package accessneo4jdata.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController //this class will be run when starting the application class. The methods will be called by entering endpoints into the browser.
public class UserController {

    @Autowired
    UserService userService; //bean

    @GetMapping(path="/rest/neo4j/user") //I want the information below to be shown at this endpoint
    public Collection<User> getAll(){
        return userService.getAll();
    }

    //TODO: add more stuff here
}
