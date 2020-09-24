package labs.khobfa.spanning_tree;

import labs.khobfa.structure.WeightedGraph;
import labs.khobfa.union_find.QuickUnion;
import labs.khobfa.union_find.UnionFind;
import labs.khobfa.union_find.WeightedQuickUnion;

import java.util.*;

public class KruskalMST {

    private int weight = 0;
    private final Queue<WeightedGraph.Edge> mst;

    public KruskalMST(WeightedGraph graph) {
        mst = new LinkedList<>();
        PriorityQueue<WeightedGraph.Edge> queue = new PriorityQueue<>((Collection<? extends WeightedGraph.Edge>) graph.allEdges());
        UnionFind unionFind = new QuickUnion(graph.vertices);


        while (!queue.isEmpty() && mst.size() < graph.vertices - 1) {
            WeightedGraph.Edge edge = queue.remove();
            int v = edge.either();
            int w = edge.other(v);

            if (!unionFind.isConnected(v, w)) {
                unionFind.union(v, w);
                mst.add(edge);
                weight += edge.getWeight();
            }
        }
    }

    public int getWeight() {
        return weight;
    }

    public Iterable<WeightedGraph.Edge> edges() {
        return mst;
    }
}
