package labs.khobfa.spanning_tree;

import labs.khobfa.structure.WeightedGraph;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class KruskalMSTTest {

    @Test
    public void givenMST_return50MinWEight() {
        // GIVEN
        KruskalMST kruskalMST = new KruskalMST(createGraph());

        // WHEN
        int weight = kruskalMST.getWeight();

        // THEN
        assertThat(weight, is(equalTo(50)));

//        assertThat(kruskalMST.edges(), hasItems(
//                hasProperty("weight", is(equalTo(4.0))),
//                hasProperty("weight", is(equalTo(5.0))),
//                hasProperty("weight", is(equalTo(6.0))),
//                hasProperty("weight", is(equalTo(7.0))),
//                hasProperty("weight", is(equalTo(8.0))),
//                hasProperty("weight", is(equalTo(9.0))),
//                hasProperty("weight", is(equalTo(11.0)))
//        ));
    }

    private WeightedGraph createGraph() {
        WeightedGraph weightedGraph = new WeightedGraph(8);

        weightedGraph.addEdge(new WeightedGraph.Edge(0, 1, 4));
        weightedGraph.addEdge(new WeightedGraph.Edge(0, 2, 10));
        weightedGraph.addEdge(new WeightedGraph.Edge(0, 3, 6));
        weightedGraph.addEdge(new WeightedGraph.Edge(1, 5, 24));
        weightedGraph.addEdge(new WeightedGraph.Edge(2, 3, 8));
        weightedGraph.addEdge(new WeightedGraph.Edge(2, 4, 10));
        weightedGraph.addEdge(new WeightedGraph.Edge(2, 7, 21));
        weightedGraph.addEdge(new WeightedGraph.Edge(3, 4, 5));
        weightedGraph.addEdge(new WeightedGraph.Edge(3, 5, 23));
        weightedGraph.addEdge(new WeightedGraph.Edge(4, 5, 18));
        weightedGraph.addEdge(new WeightedGraph.Edge(4, 6, 11));
        weightedGraph.addEdge(new WeightedGraph.Edge(4, 7, 14));
        weightedGraph.addEdge(new WeightedGraph.Edge(5, 6, 9));
        weightedGraph.addEdge(new WeightedGraph.Edge(5, 7, 13));
        weightedGraph.addEdge(new WeightedGraph.Edge(6, 7, 7));

        return weightedGraph;
    }
}
