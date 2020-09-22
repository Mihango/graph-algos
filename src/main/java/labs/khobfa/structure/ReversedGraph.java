package labs.khobfa.structure;

import java.util.LinkedList;

public class ReversedGraph implements Graph {

    private final int vertices;
    private final LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public ReversedGraph(DiGraph graph) {
        vertices = graph.getVertices();
        adj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
        reverse(graph);
    }

    private void reverse(DiGraph graph) {
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            if (!visited[i])
                dfs(graph, i, visited);
        }
    }

    private void dfs(DiGraph graph, int source, boolean[] visited) {
        if (visited[source]) return;

        visited[source] = true;

        for (int node : graph.adjacent(source)) {
            addEdge(node, source);
            if(!visited[node]) dfs(graph, node, visited);
        }
    }

    @Override
    public Iterable<Integer> adjacent(int x) {
        return x < vertices ? adj[x] : null;
    }

    @Override
    public void addEdge(int x, int y) {
        if (x < vertices && y < vertices)
            adj[x].add(y);
    }

    @Override
    public int getVertices() {
        return vertices;
    }
}
