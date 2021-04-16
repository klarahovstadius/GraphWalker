package accessneo4jdata.myexample;

import accessneo4jdata.defaultexample.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "user", path = "user") //path=endpoint
public interface UserRepository extends PagingAndSortingRepository<User, Long> { //Note "User,Long"

    List<Person> findByName(@Param("name") String name);

}
