package labs.khobfa.cycle;

import labs.khobfa.structure.DiGraph;
import labs.khobfa.structure.Graph;

import java.util.Stack;

public class CycleDetectorTopological implements CycleDetector {

    boolean[] visited;
    int[] edgeTo;
    boolean[] onStack;
    private Stack<Integer> cycle;

    public CycleDetectorTopological(DiGraph graph) {
        visited = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];
        onStack = new boolean[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
            if (!visited[v] && cycle == null)
                dfs(graph, v);
        }
    }

    private void dfs(Graph graph, int source) {
        if (visited[source]) return;

        onStack[source] = true;
        visited[source] = true;

        for (int node : graph.adjacent(source)) {
            if (cycle == null) return;
            else if (!visited[node]) {
                edgeTo[node] = source;
                dfs(graph, node);
            } else if (onStack[node]) {
                cycle = new Stack<>();
                for (int x = source; x != node; x=edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(node);
                cycle.push(source);
            }
        }
        onStack[source] = false;
    }

    public Stack<Integer> getCycle() {
        return cycle;
    }
}
