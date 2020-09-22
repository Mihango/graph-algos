package labs.khobfa.search;

import labs.khobfa.structure.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public Iterable<Integer> bfs(UndirectedGraph graph, int source) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVertices()];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            result.add(node);

            for (int n : graph.adjacent(node)) {
                queue.add(n);
                visited[n] = true;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        Iterable<Integer> iter = breadthFirstSearch.bfs(graph, 0);

        iter.forEach(i -> System.out.print(i + ", "));

    }
}
