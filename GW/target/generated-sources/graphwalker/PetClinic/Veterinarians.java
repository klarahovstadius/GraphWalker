// Generated by GraphWalker (http://www.graphwalker.org)
package PetClinic;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "PetClinic/PetClinic.json")
public interface Veterinarians {

    @Edge()
    void e_Search();

    @Vertex()
    void v_SearchResult();

    @Vertex()
    void v_Veterinarians();
}
