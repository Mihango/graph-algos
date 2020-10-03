package labs.khobfa.search;

import labs.khobfa.structure.UndirectedGraph;
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
        List<Integer> result = depthFirstSearch.dfs(createGraph(), false);

        // THEN
        assertThat(result, contains(3, 1, 5, 6, 4, 2, 0));
    }

    static UndirectedGraph createGraph() throws Exception {
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        return graph;
    }
}
