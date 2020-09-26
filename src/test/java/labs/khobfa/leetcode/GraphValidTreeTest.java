package labs.khobfa.leetcode;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GraphValidTreeTest {

    @Test
    public void givenConnectedGraph_withoutCycle_returnTrue() {
        // GIVEN
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {0, 3},
        };
        GraphValidTree tree = new GraphValidTree();

        // WHEN
        boolean isValid = tree.validTree(4, graph);
        assertThat(isValid, is(true));
    }

    @Test
    public void givenConnectedGraph_withCycle_returnFalse() {
        // GIVEN
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {0, 3},
                {2, 0}
        };
        GraphValidTree tree = new GraphValidTree();

        // WHEN
        boolean isValid = tree.validTree(4, graph);
        assertThat(isValid, is(false));
    }

    @Test
    public void givenUnConnectedGraph_withoutCycle_returnFalse() {
        // GIVEN
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {0, 3},
                {2, 0}
        };
        GraphValidTree tree = new GraphValidTree();

        // WHEN
        boolean isValid = tree.validTree(5, graph);
        assertThat(isValid, is(false));
    }

    @Test
    public void givenGraph_withLessEdges_thanNodesMinusOne_returnFalse() {
        // GIVEN
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {0, 3},
        };
        GraphValidTree tree = new GraphValidTree();

        // WHEN
        boolean isValid = tree.validTree(5, graph);
        assertThat(isValid, is(false));
    }
}
