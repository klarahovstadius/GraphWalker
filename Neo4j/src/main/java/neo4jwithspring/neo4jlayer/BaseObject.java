package neo4jwithspring.neo4jlayer;

import neo4jwithspring.entities.User;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.neo4j.driver.Values.parameters;

/**
 * 5. Neo4j specific code
 */
@Service
public class BaseObject {

    @Autowired
    Driver driver;

    Session session;

    public Session getSession() {
        session = driver.session();
        return session;
    }

    String queryAllUsers = "MATCH (n:user) RETURN n";
    String queryUserByType = "MATCH (n:user {type: $type}) RETURN n";
    String createUser = "MERGE (n:user {name: $name, password: $password, email: $email, type: $type}) RETURN n";
    String updateUser = "MATCH (n:user) where id(n) = $id SET n.name = $name, n.email = $email, n.password = $password, n.type = $type RETURN n";


    public List<Map<String, Object>> findAllUsers() {
        return getSession().readTransaction(tx -> tx.run(queryAllUsers).list(row -> row.get("n").asMap()));
    }

    public List<Map<String, Object>> findUsersByType(String type) {
        return getSession().readTransaction(tx -> tx.run(queryUserByType, parameters("type", type)).list(row -> row.get("n").asMap()));
    }

    public Result createUser(User user) {  //post --> session.write instead of session.read
        return getSession().writeTransaction(tx -> tx.run(createUser, parameters("name", user.getName(), "password", user.getPassword(), "email", user.getEmail(), "type", user.getType())));
    }

    public void updateById(int id, User user) {
        /**
         * This is working apart from that if I don't send in a value, then I get quotation marks around the old value
         * Also try to make it work with tx instead of run
         */
        Result result = getSession().run(queryAllUsers);
        Node finalResult = result.list().get(id).get("n").asNode(); //.asMap() to get the whole structure printed
        long neoId = finalResult.id();
        if (user.getName() == null) {
            user.setName(finalResult.get("name").toString());
        }
        if (user.getPassword() == null) {
            user.setPassword(finalResult.get("password").toString());
        }
        if (user.getEmail() == null) {
            user.setEmail(finalResult.get("email").toString());
        }
        if (user.getType() == null) {
            user.setType(finalResult.get("type").toString());
        }
        getSession().writeTransaction(tx -> tx.run(updateUser, parameters("id", neoId, "name", user.getName(), "email", user.getEmail(), "password", user.getPassword(), "type", user.getType())));

    }

}
