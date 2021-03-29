package modelimplementations.dummy;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import dummy.Untitled2;

@GraphWalker
public class Part2 extends ExecutionContext implements Untitled2 {
    @Override
    public void v_NewVertex3() {
        System.out.println("test3");
    }

    @Override
    public void v_NewVertex4() {
        System.out.println("test4");
    }

    @Override
    public void e_NewEdge6() {
        System.out.println("test6");
    }

    @Override
    public void e_NewEdge5() {
        System.out.println("test5");
    }
}
