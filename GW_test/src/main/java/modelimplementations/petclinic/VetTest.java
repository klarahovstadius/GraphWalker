package modelimplementations.petclinic;

import PetClinic.*;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

//@GraphWalker(value = "random(edge_coverage(100))")
public class VetTest extends ExecutionContext implements Veterinarians {
    @Override
    public void e_Search() {
        System.out.println("test");
    }

    @Override
    public void v_SearchResult() {
        System.out.println("test");
    }

    @Override
    public void v_Veterinarians() {
        System.out.println("test");
    }
}
