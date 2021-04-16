package springcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication automatically scans the package & its subpackages for beans
 * It will run my HelloWorldController class
 * Ctrl+F9 to update the server without restarting it
 */

@SpringBootApplication
public class AccessingServer {
    /**
     * This class is used to run a Spring context
     */
    public static void main(String[] args) {
        SpringApplication.run(AccessingServer.class, args);
    }

}

