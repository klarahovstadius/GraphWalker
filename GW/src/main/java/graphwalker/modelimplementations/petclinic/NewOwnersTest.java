package graphwalker.modelimplementations.petclinic;

import PetClinic.*;
import org.graphwalker.core.machine.ExecutionContext;

//@GraphWalker(value = "random(edge_coverage(100))")
public class NewOwnersTest extends ExecutionContext implements NewOwner {

    @Override
    public void v_OwnerInformation() {
        System.out.println("test");
    }

    @Override
    public void e_CorrectData() {
        System.out.println("test");
    }

    @Override
    public void e_IncorrectData() {
        System.out.println("test");
    }

    @Override
    public void v_IncorrectData() {
        System.out.println("test");
    }

    @Override
    public void v_NewOwner() {
        System.out.println("test");
    }
}
