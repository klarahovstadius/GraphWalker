package graphwalker;

import graphwalker.modelimplementations.dummy.Part1;
import graphwalker.modelimplementations.dummy.Part2;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.generator.QuickRandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;
import org.junit.Test;

public class runner {

    public void startTest(TestExecutor executor) throws Exception {
        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println("Errors found");
                System.out.println(error);
                throw new Exception();
            }
        }
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }

    public void runWebSocket(TestExecutor executor) {
        WebSocketServer server = new WebSocketServer(9991, executor.getMachine());
        server.start();
    }

    /**
     * Regression test
     */
    @Test
    public void regressionTest() throws Exception {
        TestExecutor executor = new TestExecutor(
                Part1.class,
                Part2.class
        );
        for (Context context : executor.getMachine().getContexts()) {
            if (context instanceof Part1) {
                context.setPathGenerator(new QuickRandomPath(new EdgeCoverage(100)));
            }
            if (context instanceof Part2) {
                context.setPathGenerator(new QuickRandomPath(new ReachedVertex("v_NewVertex4")));
            }
        }
        //runWebSocket(executor);
        startTest(executor);
    }
}
