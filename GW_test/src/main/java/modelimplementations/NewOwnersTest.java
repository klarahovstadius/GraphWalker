package modelimplementations;

import interfacesPetClinic.NewOwner;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))")
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
