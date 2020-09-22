package labs.khobfa.cycle;

import labs.khobfa.structure.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectorBFSAndDFS implements CycleDetector {

    public boolean isCycleBFS(Graph graph, int source) {
        int[] visited = new int[graph.getVertices()];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = 1;

            for (int n : graph.adjacent(node)) {
                if (visited[n] == 0) return true;
                else if (visited[n] == -1) {
                    queue.add(n);
                    visited[n] = 0;
                }

            }
        }
        return false;
    }

    public boolean isCycleDFS(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        // Arrays.fill(visited, -1);

        for (int i = 0; i < graph.getVertices(); i++)
            if (!visited[i])
                if (dfs(graph, i, visited)) return true;

        return false;
    }

    private boolean dfs(Graph graph, int source, boolean[] visited) {
        if (visited[source]) return true;

        boolean cycle = false;
        visited[source] = true;
        for (int node : graph.adjacent(source)) {
            if (visited[node]) cycle = dfs(graph, node, visited);
        }
        visited[source] = false;
        return cycle;
    }
}
