package labs.khobfa;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class BreadthFirstSearchTest {

    @Test
    public void getLevelTraversal_returnCollectOrder() throws Exception {
        // GIVEN
        Graph graph = DepthFirstSearchTest.createGraph();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        // WHEN
        Iterable<Integer> iter = breadthFirstSearch.bfs(graph, 0);

        // THEN
        assertThat(iter, contains(0, 1, 2, 3, 4, 5, 6));
    }
}
