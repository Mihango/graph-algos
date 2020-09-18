package labs.khobfa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public Iterable<Integer> bfs(Graph graph, int source) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVertices()];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            result.add(node);

            for (int n : graph.getAdjacent(node)) {
                queue.add(n);
                visited[n] = true;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addAdjacent(0, 1);
        graph.addAdjacent(0, 2);
        graph.addAdjacent(1, 3);
        graph.addAdjacent(2, 4);
        graph.addAdjacent(4, 5);
        graph.addAdjacent(4, 6);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        Iterable<Integer> iter = breadthFirstSearch.bfs(graph, 0);

        iter.forEach(i -> System.out.print(i + ", "));

    }
}
