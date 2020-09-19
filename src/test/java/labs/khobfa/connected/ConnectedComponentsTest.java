package labs.khobfa.connected;

import labs.khobfa.Graph;
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

    private Graph create() {
        Graph graph = new Graph(10);
        graph.addAdjacent(0, 1);
        graph.addAdjacent(0, 2);
        graph.addAdjacent(1, 2);
        graph.addAdjacent(1, 3);
        graph.addAdjacent(2, 3);


        graph.addAdjacent(4, 5);
        graph.addAdjacent(4, 6);


        graph.addAdjacent(7, 8);
        graph.addAdjacent(7, 9);
        graph.addAdjacent(8, 9);

        return graph;
    }
}
