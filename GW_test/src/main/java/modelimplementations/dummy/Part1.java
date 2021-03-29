package modelimplementations.dummy;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import dummy.Untitled1;

@GraphWalker
public class Part1 extends ExecutionContext implements Untitled1 {
    @Override
    public void e_NewEdge2() {
            System.out.println("test2");
    }

    @Override
    public void v_NewVertex() {
        System.out.println("test1");
    }

    @Override
    public void v_NewVertex2() {
        System.out.println("test2");
    }

    @Override
    public void e_NewEdge() {
        System.out.println("test1");
    }
}
