package labs.khobfa.connected;

import labs.khobfa.Graph;

public class ConnectedComponents {
    private final int[] ids;
    private final boolean[] visited;
    private int count = 0;

    public ConnectedComponents(Graph graph) {
        ids = new int[graph.getVertices()];
        visited = new boolean[graph.getVertices()];

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(graph, i);
                ++count;
            }
        }
    }

    private void dfs(Graph graph, int source) {
        if (visited[source]) return;

        visited[source] = true;
        ids[source] = count;

        for (int node : graph.getAdjacent(source)) {
            if (!visited[node])
                dfs(graph, node);
        }
    }

    public boolean isConnected(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x >= ids.length || y < 0 || y >= ids.length) throw new IndexOutOfBoundsException();
        return ids[x] == ids[y];
    }

    public int getCount() {
        return count;
    }
}
