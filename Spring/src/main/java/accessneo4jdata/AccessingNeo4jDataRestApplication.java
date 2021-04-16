
package accessneo4jdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @SpringBootApplication automatically scans the package & its subpackages for beans
 *   Enables auto configuration
 */

@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class AccessingNeo4jDataRestApplication {
	/**
	 * This class is used to run a Spring context
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccessingNeo4jDataRestApplication.class, args);
	}
}
