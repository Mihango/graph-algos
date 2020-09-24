package labs.khobfa.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {

    private final LinkedList<Edge>[] adj;
    public final int vertices;
    private int edges;

    static public class Edge implements Comparable<Edge> {
        private final int src;
        private final int dest;
        private final double weight;

        public Edge(int src, int dest, double weight) {
            if (src < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
            if (dest < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
            if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int either() {
            return src;
        }

        public int other(int vertex) {
            if (vertex == src) return dest;
            else if (vertex == dest) return src;
            else throw new IllegalArgumentException("Illegal endpoint");
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return Double.compare(this.weight, edge.getWeight());
        }

        public String toString() {
            return String.format("%d-%d %.5f", src, dest, weight);
        }
    }

    @SuppressWarnings("unchecked")
    public WeightedGraph(int size) {
        if (size < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");

        this.vertices = size;
        this.edges = 0;
        this.adj = (LinkedList<Edge>[]) new LinkedList[vertices];

        for (int i = 0; i < vertices; i++)
            this.adj[i] = new LinkedList<>();
    }

    public void addEdge(Edge edge) {
        int src = edge.either();
        int dest = edge.other(src);
        this.adj[src].add(edge);
        this.adj[dest].add(edge);
        this.edges++;
    }

    public Iterable<Edge> adjacent(int src) {
        return this.adj[src];
    }

    public int getEdges() {
        return edges;
    }

    public Iterable<Edge> allEdges() {
        List<Edge> list = new ArrayList<>();

        for (int v = 0; v < vertices; v++) {
            int selfLoops = 0;
            for (Edge edge : adj[v]) {
                if (edge.other(v) > v) {
                    list.add(edge);
                }
                else if (edge.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(edge);
                    selfLoops++;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(5);

        weightedGraph.addEdge(new Edge(2, 4, 10));
        weightedGraph.addEdge(new Edge(0, 2, 6));
        weightedGraph.addEdge(new Edge(0, 1, 3));
        weightedGraph.addEdge(new Edge(0, 3, 7));
        weightedGraph.addEdge(new Edge(1, 3, 1));
        weightedGraph.addEdge(new Edge(3, 4, 8));
        weightedGraph.addEdge(new Edge(1, 1, 4));
        weightedGraph.addEdge(new Edge(1, 1, 3));


        System.out.println("No. of edges >>> " + weightedGraph.edges);

        System.out.println("\n>>> all edges adjacent to 0 >>>>");
        weightedGraph.adjacent(0).forEach(System.out::println);

        System.out.println("\n>>> all edges adjacent to 1 >>>>");
        weightedGraph.adjacent(1).forEach(System.out::println);

        System.out.println("\n>>> all edges adjacent to 2 >>>>");
        weightedGraph.adjacent(2).forEach(System.out::println);

        System.out.println("\n>>>>>>>> all edges >>>>>>>>>>>>>");
        weightedGraph.allEdges().forEach(System.out::println);

    }
}
