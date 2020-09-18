package labs.khobfa;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void addItemsToGraph_returnSize() {
        // GIVEN
        Graph graph = new Graph(5);
        // WHEN adjacent nodes are empty

        // THEN size should be equal to created list
        assertEquals(5, graph.getVertices());
    }

    @Test
    public void getAdjacentOfNode_returnExists() throws Exception {
        // GIVEN
        Graph graph = new Graph(6);

        // WHEN
        graph.addAdjacent(0, 3);
        graph.addAdjacent(0, 4);
        Iterable<Integer> iter = graph.getAdjacent(0);

        // THEN
        assertThat(iter, contains(3, 4));
    }
}
