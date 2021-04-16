package springcourse.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @RestController = rest service
 * This class is run via the class "AccessingTomcat"
 * It will create a new URI with a text displayed
 * GET
 */
@RestController
public class HelloWorldController {

    /**
     * Map the GET request to a URI and method
     * "Hello World this is Klara" will be displayed in the browser
     */
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World this is Klara";
    }

    /**
     * Same as above but with a bean
     * Sending the text "Hello World" to the HelloWorldBean method, to display this text in the browser
     * When having a bean, the text will be shown as a JSON format in the browser (done by Spring boot autoconfiguration)
     */
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World"); //bean
    }

    /**
     * Same as above but with a path variable {name}
     * /hello-world/path-variable/in28minutes is an example of a URI
     * "in28minutes" is mapped to {name} in the path
     * whatever I add after /path-variable/ will lead to a webpage with a text displayed
     */
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name)); //% will be replaced by name ({"message":"Hello World, in28minutes"})
    }


}
