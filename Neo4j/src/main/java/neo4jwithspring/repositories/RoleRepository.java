package neo4jwithspring.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleRepository {

    List<Map<String, Object>> findAllRoles();

}
