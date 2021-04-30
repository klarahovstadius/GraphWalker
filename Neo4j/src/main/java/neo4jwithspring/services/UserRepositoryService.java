package neo4jwithspring.services;

import neo4jwithspring.entities.User;
import neo4jwithspring.exceptions.UserNotFoundException;
import neo4jwithspring.neo4jlayer.BaseObject;
import neo4jwithspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Profile({"neo4j", "default"})
@Service
public class UserRepositoryService implements UserRepository {

    @Autowired
    BaseObject baseObject;

    @Override
    public List<Map<String, Object>> findAll() {
        return baseObject.findAllUsers();
    }

    @Override
    public Object findOne(int id) {
        List<Map<String, Object>> result = baseObject.findAllUsers();
        return userValidation(id, result);
    }

    public Object userValidation(int id, List<Map<String, Object>> results) {
        if (id > results.size() - 1) {
            throw new UserNotFoundException("id-" + id + " not found");
        } else {
            return results.get(id); //choosing a specific part of the object list
        }
    }

    @Override
    public List<Map<String, Object>> findByType(String type) {
        return baseObject.findUsersByType(type);
    }

    @Override
    public String createUser(User user) {
        baseObject.createUser(user);
        return "User created";
    }

    @Override
    public String updateById(int id, User user) {
        baseObject.updateById(id, user);
        return "User updated";
    }


}
