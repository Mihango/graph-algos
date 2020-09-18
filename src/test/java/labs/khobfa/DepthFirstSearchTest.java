package labs.khobfa;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class DepthFirstSearchTest {

    @Test
    public void getDfs_showCorrectOrder() throws Exception {
        // GIVEN
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        // WHEN
        List<Integer> result = depthFirstSearch.dfs(createGraph(), 0);

        // THEN
        System.out.println(result.toString());
        assertThat(result, contains(3, 1, 5, 6, 4, 2, 0));
    }

    static Graph createGraph() throws Exception {
        Graph graph = new Graph(7);
        graph.addAdjacent(0, 1);
        graph.addAdjacent(0, 2);
        graph.addAdjacent(1, 3);
        graph.addAdjacent(2, 4);
        graph.addAdjacent(4, 5);
        graph.addAdjacent(4, 6);

        return graph;
    }
}
