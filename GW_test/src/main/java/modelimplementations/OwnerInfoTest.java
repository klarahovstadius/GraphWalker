package modelimplementations;

import interfacesPetClinic.OwnerInformation;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))")
public class OwnerInfoTest extends ExecutionContext implements OwnerInformation {

    public void v_OwnerInformation() {
        System.out.println("test");
    }

    public void e_UpdatePet() {
        System.out.println("test");
    }

    public void v_FindOwners() {
        System.out.println("test");
    }

    public void e_EditPet() {
        System.out.println("test");
    }

    public void e_AddNewPet() {
        System.out.println("test");
    }

    public void e_AddVisit() {
        System.out.println("test");
    }

    public void e_FindOwners() {
        System.out.println("test");
    }

    public void e_AddPetSuccessfully() {
        System.out.println("test");
    }

    public void v_NewPet() {
        System.out.println("test");
    }

    public void e_VisitAddedSuccessfully() {
        System.out.println("test");
    }

    public void v_NewVisit() {
        System.out.println("test");
    }

    public void v_Pet() {
        System.out.println("test");
    }

    public void e_AddPetFailed() {
        System.out.println("test");
    }

    public void e_VisitAddedFailed() {
        System.out.println("test");
    }
}
