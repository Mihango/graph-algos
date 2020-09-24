package labs.khobfa.connected;

import labs.khobfa.structure.DiGraph;
import labs.khobfa.structure.Graph;
import labs.khobfa.structure.ReversedGraph;

import java.util.List;
import java.util.Stack;

/**
 * calculate connected components in a directed graph - the idea is that the strongly connected components should
 * be the same in directed graph and the reverse of it
 */
public class KosarajuSharirSCC {

    private final int[] ids; // connected components id
    private final boolean[] visited; // for dfs
    private int count = 0;

    public KosarajuSharirSCC(DiGraph graph) {
        ids = new int[graph.getVertices()];
        visited = new boolean[graph.getVertices()];

        ReversedGraph reversedGraph = new ReversedGraph(graph);
        Stack<Integer> reversePost = (Stack<Integer>) reversePostOrder(reversedGraph);

        while (!reversePost.isEmpty()) {
            int i = reversePost.pop();
            if (!visited[i]) {
                dfs(i, graph);
                ++count;
            }
        }
    }

    private boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    public int components() {
        return count;
    }

    private List<Integer> reversePostOrder(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        List<Integer> result = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            dfs(i, graph, visited, result);
        }
        return result;
    }

    private void dfs(int node, Graph graph) {
        if (visited[node]) return;

        visited[node] = true;
        ids[node] = count;
        for (int n : graph.adjacent(node)) dfs(n, graph);
    }

    private void dfs(int node, Graph graph, boolean[] visited, List<Integer> list) {
        if (visited[node]) return;

        visited[node] = true;
        for (int n : graph.adjacent(node)) {
            if (!visited[n]) dfs(n, graph, visited, list);
        }
        list.add(node);
    }

}
