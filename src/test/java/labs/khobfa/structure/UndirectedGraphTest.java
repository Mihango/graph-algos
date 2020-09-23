package labs.khobfa.structure;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UndirectedGraphTest {

    @Test
    public void addItemsToGraph_returnSize() {
        // GIVEN
        UndirectedGraph graph = new UndirectedGraph(5);
        // WHEN adjacent nodes are empty

        // THEN size should be equal to created list
        assertEquals(5, graph.getVertices());
    }

    @Test
    public void getAdjacentOfNode_returnExists() {
        // GIVEN
        UndirectedGraph graph = new UndirectedGraph(6);

        // WHEN
        graph.addEdge(0, 3);
        graph.addEdge(0, 9);
        Iterable<Integer> iter = graph.adjacent(0);

        // THEN
        assertThat(iter, contains(3, 9));
    }
}
