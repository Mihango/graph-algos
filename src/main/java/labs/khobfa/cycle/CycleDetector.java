package labs.khobfa.cycle;

import labs.khobfa.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetector {

    public boolean isCycleBFS(Graph graph, int source) {
        int[] visited = new int[graph.getVertices()];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = 1;

            for (int n : graph.getAdjacent(node)) {
                if (visited[n] == 0) return true;
                else if (visited[n] == -1) {
                    queue.add(n);
                    visited[n] = 0;
                }

            }
        }
        return false;
    }
}
