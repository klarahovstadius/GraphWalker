package neo4jwithspring.services;

import neo4jwithspring.repositories.RoleRepository;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService implements RoleRepository {

    @Autowired
    Driver driver;

    String query;

    @Override
    public List<Map<String, Object>> findAllRoles() {
        query = "MATCH (n:role) RETURN n";
        Session session = driver.session();
        query = "MATCH (n:user) RETURN n";
        //Map<String, Object> params = new HashMap<String, Object>() {{}};
        return session.readTransaction(tx -> {
            return tx.run(query).list(row -> row.get("n").asMap());
        });
    }


}
