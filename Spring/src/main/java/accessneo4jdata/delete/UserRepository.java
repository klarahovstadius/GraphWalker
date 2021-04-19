package accessneo4jdata.delete;

//import org.springframework.data.neo4j.annotation.Query; //DOESN'T WORK WITH CURRENT RELEASE
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query; //WRONG

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User,Long> { //type of object and primary key

    @Query("MATCH (n:user) RETURN n")
    Collection<User> getAllUsers();

}
