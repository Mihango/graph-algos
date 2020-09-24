package labs.khobfa.connected;

import labs.khobfa.structure.DiGraph;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class KosarajuSharirSCCTest {

    @Test
    public void testComponentSCC() {
        KosarajuSharirSCC scc = new KosarajuSharirSCC(createGraph());

        int count = scc.components();

        assertThat(count, is(equalTo(5)));
    }

    private DiGraph createGraph() {
        DiGraph graph = new DiGraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(7, 9);
        graph.addEdge(8, 6);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(10, 12);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);

        return graph;
    }
}
