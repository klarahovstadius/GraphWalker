package neo4jwithspring.repositories;

import neo4jwithspring.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository{

    List<Map<String, Object>> findAll();

    Object findOne(int id);

    String createUser(User user);

    String updateById(int id, User user);

    List<Map<String, Object>> findByType(String type) throws Exception;

}
