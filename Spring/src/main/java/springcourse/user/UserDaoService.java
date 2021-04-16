package springcourse.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component //I think this is used for the @Autowired in UserResource
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    private static List<UserPost> posts = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
        posts.add(new UserPost("comment", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    /**
     * User related methods
     */
    public User save(User user) { //Call this to add a new user to the list "users"
        if (user.getId() == null) {
            //When send in name and birthdate via Postman, so here we will just need to define the id
            user.setId(++usersCount); //the next available id
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
