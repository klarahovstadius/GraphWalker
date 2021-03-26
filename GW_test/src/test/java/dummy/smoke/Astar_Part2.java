package dummy.smoke;

import modelimplementations.dummy.Part1;
import modelimplementations.dummy.Part2;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))")
//I would like to have "a_star" here isntead (like below), but I get stuck in a loop when combining it with "quick_random" in the other module (Astar_Part 1)
//@GraphWalker(value = "a_star(reached_vertex(v_NewVertex4))")
public class Astar_Part2 extends Part2 {
}
