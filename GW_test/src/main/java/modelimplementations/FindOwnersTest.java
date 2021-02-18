package modelimplementations;

import interfacesPetClinic.FindOwners;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))")
public class FindOwnersTest extends ExecutionContext implements FindOwners {
    @Override
    public void v_Owners() {
        System.out.println("test");
    }

    @Override
    public void e_AddOwner() {
        System.out.println("test");
    }

    @Override
    public void v_FindOwners() {
        System.out.println("test");
    }

    @Override
    public void e_Search() {
        System.out.println("test");
    }

    @Override
    public void e_FindOwners() {
        System.out.println("test");
    }

    @Override
    public void v_NewOwner() {
        System.out.println("test");
    }
}
