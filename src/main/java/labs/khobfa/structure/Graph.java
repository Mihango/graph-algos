package labs.khobfa.structure;

public interface Graph {
    Iterable<Integer> adjacent(int x);
    void addEdge(int x, int y);
    int getVertices();
}
