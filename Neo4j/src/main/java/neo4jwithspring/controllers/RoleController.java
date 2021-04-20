package neo4jwithspring.controllers;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    Driver driver;

    @GetMapping(path = "/role", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllRoles() {
        Session session = driver.session();
        return session.run("MATCH (n:role) RETURN n").list(r -> r.get("n").asNode().get("name").asString());
    }
}
