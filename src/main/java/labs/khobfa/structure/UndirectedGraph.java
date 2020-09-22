package labs.khobfa.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph implements Graph {

    public final int vertices;
    List<LinkedList<Integer>> data;

    public UndirectedGraph(int size) {
        this.vertices = size;
        data = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            data.add(i, new LinkedList<>());
        }
    }

    @Override
    public Iterable<Integer> adjacent(int x) {
        return data.get(x);
    }

    @Override
    public void addEdge(int x, int y) {
        if (x > vertices || y > vertices) throw new IndexOutOfBoundsException();
        data.get(x).add(y);
        data.get(y).add(x);
    }

    public int getVertices() {
        return vertices;
    }
}
