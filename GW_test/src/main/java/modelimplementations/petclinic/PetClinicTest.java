package modelimplementations.petclinic;

import PetClinic.*;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

//@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowser")
public class PetClinicTest extends ExecutionContext implements PetClinic {
    @Override
    public void v_FindOwners() {
        System.out.println("test");
    }

    @Override
    public void e_HomePage() {
        System.out.println("test");
    }

    @Override
    public void e_StartBrowser() {
        System.out.println("test");
    }

    @Override
    public void e_Veterinarians() {
        System.out.println("test");
    }

    @Override
    public void v_Veterinarians() {
        System.out.println("test");
    }

    @Override
    public void e_FindOwners() {
        System.out.println("test");
    }

    @Override
    public void v_HomePage() {
        System.out.println("test");
    }
}
