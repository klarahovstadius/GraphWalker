package neo4jwithspring.controllers;

import neo4jwithspring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    /**
     * Here is another option using Neo4j + Spring boot which I like more
     */
    @Autowired
    RoleRepository roleRepository;

    @GetMapping(path = "/role", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, Object>> getAllRoles() {
        return roleRepository.findAllRoles();
    }
}
