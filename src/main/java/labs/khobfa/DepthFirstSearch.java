package labs.khobfa;

import java.util.Stack;

public class DepthFirstSearch {

    public Iterable<Integer> dfs(Graph graph, int source) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.vertices];
        dfs(graph, source, visited, stack);
        return stack;
    }

    private void dfs(Graph graph, int source, boolean[] visited, Stack<Integer> stack) {
        if (visited[source]) return;

        visited[source] = true;
        stack.add(source);

        for (int node : graph.getAdjacent(source)) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(graph, node, visited, stack);
            }
        }
    }
}
