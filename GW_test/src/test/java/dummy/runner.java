package dummy;

import dummy.smoke.Astar_Part1;
import dummy.smoke.Astar_Part2;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;
import org.junit.Test;
import dummy.regression.quick_random_Part1;
import dummy.regression.quick_random_Part2;

import java.io.IOException;

public class runner {

    public void startTest(TestExecutor executor) {
        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println("Errors found");
                System.out.println(error);
            }
        }
        //TODO: set status to fail if it fails
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }

    public void runWebSocket(TestExecutor executor) {
        WebSocketServer server = new WebSocketServer(9991, executor.getMachine());
        server.start();
    }

    /**
     * Smoke test
     */
    @Test
    public void smokeTest() throws IOException {
        TestExecutor executor = new TestExecutor(
                Astar_Part1.class,
                Astar_Part2.class
        );
        //runWebSocket(executor);
        startTest(executor);
    }

    /**
     * Regression test
     */
    @Test
    public void regressionTest() throws IOException {
        TestExecutor executor = new TestExecutor(
                quick_random_Part1.class,
                quick_random_Part2.class
        );
        //runWebSocket(executor);
        startTest(executor);
    }
}
