package accessneo4jdata.myexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Neo4jMyTests {

    /**
     * @Autowired means dependency (to the bean).
     *   It eliminates the need for setters and getters.
     * Bean=instance of an object
     * With Spring we don't need try/catch
     * Spring boot is used as a framework for creating microservices/applications
     */
    @Autowired //instead of "MockMvc mockMvc = new MockMvc;"
    private MockMvc mockMvc;

    @Test
    public void query() throws Exception {
        // /user is the endpoint and should match the endpoint in the interface "path"
        mockMvc.perform(post("/user").content(
                "{ \"name\": \"User5\"}")).andExpect(
                status().isCreated());

        /*mockMvc.perform(
                get("/people/search/findByName?name={name}", "User5")).andExpect(
                status().isOk()).andExpect(
                jsonPath("$._embedded.people[0].name").value(
                        "User5"));*/
    }

}
