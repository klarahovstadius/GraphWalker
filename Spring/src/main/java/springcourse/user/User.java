package springcourse.user;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Date birthDate;

    protected User(){ //default no-argument constructor (if we need to call the User method without sending in id, name, birthdate
        //this is needed when sending a post request via e.g. Postman to create a new user
    }

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Setters and getters are mandatory
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
