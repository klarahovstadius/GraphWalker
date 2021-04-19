package neo4jwithspring.newtest.controllers;

import neo4jwithspring.newtest.User;
import neo4jwithspring.newtest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    private final Driver driver;

    public UserController(Driver driver) {
        this.driver = driver; //constructor
    }

    @GetMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllUsers() {
       try(Session session = driver.session()) {
           return session.run("MATCH (n:user) RETURN n").list(r -> r.get("n").asNode().get("name").asString());
       }
        //return userRepository.getUsers();
    }

    @GetMapping(path="/role",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllRoles() {
        try(Session session = driver.session()) {
            return session.run("MATCH (n:role) RETURN n").list(r -> r.get("n").asNode().get("name").asString());
        }
    }
}
