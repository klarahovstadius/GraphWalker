package springcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @SpringBootApplication automatically scans the package & its subpackages for beans
 * It will run my HelloWorldController class
 * Ctrl+F9 to update the server without restarting it
 */

@SpringBootApplication
public class AccessingTomcat {
    /**
     * This class is used to run a Spring context
     */
    public static void main(String[] args) {
        SpringApplication.run(AccessingTomcat.class, args);
    }

}

