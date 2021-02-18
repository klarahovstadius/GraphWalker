// Generated by GraphWalker (http://www.graphwalker.org)
package interfacesPetClinic;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "PetClinic/PetClinic.json")
public interface NewOwner {

    @Vertex()
    void v_OwnerInformation();

    @Edge()
    void e_CorrectData();

    @Edge()
    void e_IncorrectData();

    @Vertex()
    void v_IncorrectData();

    @Vertex()
    void v_NewOwner();
}
