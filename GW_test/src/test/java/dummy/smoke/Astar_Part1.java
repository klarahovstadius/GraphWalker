package dummy.smoke;

import modelimplementations.dummy.Part1;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))")
public class Astar_Part1 extends Part1 {
}
