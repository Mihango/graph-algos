package labs.khobfa.search;

import labs.khobfa.structure.UndirectedGraph;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public List<Integer> dfs(UndirectedGraph graph, boolean preOrder) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.getVertices()];
        for(int i = 0; i < graph.vertices; i++)
            if(!visited[i]) dfs(graph, i, visited, stack, preOrder);
        return stack;
    }

    private void dfs(UndirectedGraph graph, int source, boolean[] visited,
                     Stack<Integer> stack, boolean preOrder) {

        visited[source] = true;

        if (preOrder) {
            stack.push(source);
        }

        for (int node : graph.adjacent(source)) {
            if (!visited[node]) {
                dfs(graph, node, visited, stack, preOrder);
            }
        }

        if (!preOrder) {
            stack.push(source);
        }
    }
}
