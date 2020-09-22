package labs.khobfa.structure;

import java.util.LinkedList;

public class DiGraph implements Graph {

    private final int vertices;
    LinkedList<Integer>[] data;

    @SuppressWarnings("unchecked")
    public DiGraph(int size) {
        this.vertices = size;
        data = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public Iterable<Integer> adjacent(int x) {
        return data[x];
    }

    public void addEdge(int x, int y) {
        if (x > vertices || y > vertices) throw new IndexOutOfBoundsException();
        data[x].add(y);
    }

    @Override
    public int getVertices() {
        return vertices;
    }
}
