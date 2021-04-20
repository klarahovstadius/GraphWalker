package neo4jwithspring.services;

import neo4jwithspring.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    public String userValidation(int id, List<Object> results){
        if (id > results.size() - 1) {
            throw new UserNotFoundException("id-" + id + " not found");
        } else {
            return results.get(id).toString();
        }
    }

}
