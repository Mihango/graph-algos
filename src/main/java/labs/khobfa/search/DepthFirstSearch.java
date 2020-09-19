package labs.khobfa.search;

import labs.khobfa.Graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public List<Integer> dfs(Graph graph, int source, boolean preOrder) {
        List<Integer> stack = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        dfs(graph, source, visited, stack, preOrder);
        return stack;
    }

    private void dfs(Graph graph, int source, boolean[] visited, List<Integer> stack, boolean preOrder) {
        if (visited[source]) return;

        visited[source] = true;

        if (preOrder) {
            stack.add(source);
        }

        for (int node : graph.getAdjacent(source)) {
            if (!visited[node]) {
                dfs(graph, node, visited, stack, preOrder);
            }
        }

        if (!preOrder) {
            stack.add(source);
        }
    }
}
