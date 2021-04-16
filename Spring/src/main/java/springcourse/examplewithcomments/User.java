package springcourse.examplewithcomments;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All details about the user") //to add some documentation to the api doc
public class User {

    private Integer id;

    @Size(min=2, message ="Name should have at least 2 characters") //to have some validation of the input (at least 2 char long). To use this, we add @Valid in the get mapping. The message will be shown in the end of "details".
    @ApiModelProperty(notes="Name should have at least 2 characters") //this will be printed in the api doc (http://localhost:8082/v2/api-docs/)
    private String name;
    @Past //the date must be in the past
    @ApiModelProperty(notes="The date must be in the past")
    private Date birthDate;

    protected User(){ //default no-argument constructor (if we need to call the User method without sending in name, birthdate
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
