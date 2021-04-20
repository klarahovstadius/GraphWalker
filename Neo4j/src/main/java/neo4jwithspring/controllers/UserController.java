package neo4jwithspring.controllers;

import neo4jwithspring.exceptions.UserNotFoundException;
import neo4jwithspring.services.UserService;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Inspiration from https://neo4j.com/developer/java-driver-spring-boot-starter/
 */
@RestController
public class UserController {

    @Autowired
    Driver driver;
    @Autowired
    UserService userService;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllUsers() {
        Session session = driver.session();
        return session.run("MATCH (n:user) RETURN n").list(r -> r.get("n").asNode().get("name").asString());
    }

    @GetMapping(path = "/user/valid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllValidUsers() {
        Session session = driver.session();
        return session.run("match (n:user {type:\"valid\"}) return n").list(r -> r.get("n").asNode().get("name").asString());
    }

    @GetMapping(path = "/user/valid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOneValidUsers(@PathVariable int id) {
        Session session = driver.session();
        List<Object> results = session.run("match (n:user {type:\"valid\"}) return n").list(r -> r.get("n").asNode().get("name").asString());
        return userService.userValidation(id, results);
    }

    @GetMapping(path = "/user/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllAdminUsers() {
        Session session = driver.session();
        return session.run("match (n:user {type:\"valid\"})-[i:access_right]->(m:role {name:\"Admin role\"}) return n")
                .list(r -> r.get("n").asNode().get("name").asString());
    }

    @GetMapping(path = "/user/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOneAdminUsers(@PathVariable int id) {
        Session session = driver.session();
        List<Object> results = session.run("match (n:user)-[i:access_right]->(m:role {name:\"Admin role\"}) return n")
                .list(r -> r.get("n").asNode().get("name").asString());
        return userService.userValidation(id, results);
    }

    @GetMapping(path = "/user/spira", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllSpiraEditors() {
        Session session = driver.session();
        return session.run("match (n:user)-[i:access_right]->(m:role {name:\"Admin role\"})-[r:edit]->(o:connection) return n,i,m,r,o")
                .list(r -> r.get("n").asNode().get("name").asString());
    }

    @GetMapping(path = "/user/spira/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOneSpiraEditor(@PathVariable int id) {
        Session session = driver.session();
        List<Object> results = session.run("match (n:user)-[i:access_right]->(m:role {name:\"Admin role\"})-[r:edit]->(o:connection) return n,i,m,r,o")
                .list(r -> r.get("n").asNode().get("name").asString());
        return userService.userValidation(id, results);
        //return results.get(id).toString();
    }

}
