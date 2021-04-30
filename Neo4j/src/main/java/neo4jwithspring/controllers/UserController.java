package neo4jwithspring.controllers;

import neo4jwithspring.entities.User;
import neo4jwithspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List<Map<String, Object>> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Object getOneUser(@PathVariable int id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/type/{type}")
    public List<Map<String, Object>> findByType(@PathVariable String type) throws Exception {
        return userRepository.findByType(type);
    }

    @PostMapping()
    public String createUser(@RequestBody User user) {
        return userRepository.createUser(user);
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return userRepository.updateById(id, user);
    }
}
