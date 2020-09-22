package labs.khobfa.connected;

import labs.khobfa.structure.UndirectedGraph;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;

public class ConnectedComponentsTest {

    @Test
    public void getConnectedComponent_givenThreeDisjointGraph() {
        // GIVEN
        ConnectedComponents cc = new ConnectedComponents(create());

        // THEN
        assertThat(cc.getCount(), comparesEqualTo(3));
        assertThat(cc.isConnected(0, 3), comparesEqualTo(true));
        assertThat(cc.isConnected(7, 9), comparesEqualTo(true));
        assertThat(cc.isConnected(3, 5), comparesEqualTo(false));
    }

    private UndirectedGraph create() {
        UndirectedGraph graph = new UndirectedGraph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);


        graph.addEdge(4, 5);
        graph.addEdge(4, 6);


        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);

        return graph;
    }
}
