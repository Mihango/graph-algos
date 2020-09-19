package labs.khobfa.cycles;

import labs.khobfa.Graph;
import labs.khobfa.cycle.CycleDetector;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CycleDetectorTest {

    @Test
    public void givenGraph_withCycle_returnTrue() {
        // GIVEN
        CycleDetector cycleDetector = new CycleDetector();

        // WHEN
        boolean isCyclic = cycleDetector.isCycleBFS(createCyclic(), 0);

        // THEN
        assertThat(isCyclic, is(equalTo(true)));
    }

    @Test
    public void givenGraph_withoutCycle_returnFalse() {
        // GIVEN
        CycleDetector cycleDetector = new CycleDetector();

        // WHEN
        boolean isCyclic = cycleDetector.isCycleBFS(createAcyclic(), 0);

        // THEN
        assertThat(isCyclic, is(equalTo(false)));
    }

    private Graph createCyclic() {
        Graph graph = new Graph(5);

        graph.addAdjacent(0, 1);
        graph.addAdjacent(0, 2);
        graph.addAdjacent(2, 3);
        graph.addAdjacent(3, 4);
        graph.addAdjacent(4, 2);

        return graph;
    }

    private Graph createAcyclic() {
        Graph graph = new Graph(5);

        graph.addAdjacent(0, 1);
        graph.addAdjacent(0, 2);
        graph.addAdjacent(2, 3);
        graph.addAdjacent(2, 4);

        return graph;
    }
}
