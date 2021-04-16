package springcourse.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component //I think this is used for the @Autowired in UserResource
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static{
        users.add(new User(1,"Adam",new Date()));
        users.add(new User(2,"Eve",new Date()));
        users.add(new User(3,"Jack",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    /**
     * Call this to add a new user to the list "users"
     * When we sent in a new user with name and birthdate via Postman, it was c
     */
    public User save(User user){
        if (user.getId()==null){
            user.setId(++usersCount); //the next available id
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

}
