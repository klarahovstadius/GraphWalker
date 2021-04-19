package neo4jwithspring.newtest.repositories;

import neo4jwithspring.newtest.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    //@Query("MATCH (n:user) RETURN n")
    //Collection<User> getUses();
}
