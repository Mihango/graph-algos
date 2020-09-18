package labs.khobfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public List<Integer> dfs(Graph graph, int source) {
        List<Integer> stack = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        dfs(graph, source, visited, stack);
        return stack;
    }

    private void dfs(Graph graph, int source, boolean[] visited, List<Integer> stack) {
        if (visited[source]) return;

        visited[source] = true;

        for (int node : graph.getAdjacent(source)) {
            if (!visited[node]) {
                dfs(graph, node, visited, stack);
            }
        }
        stack.add(source);
    }
}
