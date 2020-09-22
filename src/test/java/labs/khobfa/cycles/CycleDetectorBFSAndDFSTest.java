package labs.khobfa.cycles;

import labs.khobfa.structure.DiGraph;
import labs.khobfa.structure.Graph;
import labs.khobfa.structure.UndirectedGraph;
import labs.khobfa.cycle.CycleDetectorBFSAndDFS;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CycleDetectorBFSAndDFSTest {

    @Test
    public void givenGraph_withCycle_returnTrueWithBFS() {
        // GIVEN
        CycleDetectorBFSAndDFS cycleDetectorBFSAndDFS = new CycleDetectorBFSAndDFS();

        // WHEN
        boolean isCyclic = cycleDetectorBFSAndDFS.isCycleBFS(createCyclic(true), 0);

        // THEN
        assertThat(isCyclic, is(equalTo(false)));
    }

    @Test
    public void givenGraph_withoutCycle_returnFalseWithBFS() {
        // GIVEN
        CycleDetectorBFSAndDFS cycleDetectorBFSAndDFS = new CycleDetectorBFSAndDFS();

        // WHEN
        boolean isCyclic = cycleDetectorBFSAndDFS.isCycleBFS(createAcyclic(false), 0);

        // THEN
        assertThat(isCyclic, is(equalTo(false)));
    }

    @Test
    public void givenGraph_withCycle_returnTrueWithDFS() {
        // GIVEN
        CycleDetectorBFSAndDFS cycleDetectorBFSAndDFS = new CycleDetectorBFSAndDFS();

        // WHEN
        boolean isCyclic = cycleDetectorBFSAndDFS.isCycleDFS(createCyclic(true));

        // THEN
        assertThat(isCyclic, is(equalTo(true)));
    }

    @Test
    public void givenGraph_withoutCycle_returnFalseWithDFS() {
        // GIVEN
        CycleDetectorBFSAndDFS cycleDetectorBFSAndDFS = new CycleDetectorBFSAndDFS();

        // WHEN
        boolean isCyclic = cycleDetectorBFSAndDFS.isCycleDFS(createAcyclic(true));

        // THEN
        assertThat(isCyclic, is(equalTo(false)));
    }

    private Graph createCyclic(boolean directed) {
        Graph graph = directed ? new DiGraph(2)
                : new UndirectedGraph(2);


        graph.addEdge(1, 0);
        if(!directed) graph.addEdge(0, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 2);

        return graph;
    }

    private Graph createAcyclic(boolean directed) {
        Graph graph = directed ? new DiGraph(5)
                : new UndirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        return graph;
    }
}
