package labs.khobfa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final int vertices;
    List<LinkedList<Integer>> data;

    public Graph(int size) {
        this.vertices = size;
        data = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            data.add(i, new LinkedList<>());
        }
    }

    public Iterable<Integer> getAdjacent(int x) {
        return data.get(x);
    }

    public void addAdjacent(int x, int y) {
        if (x > vertices || y > vertices) throw new IndexOutOfBoundsException();
        data.get(x).add(y);
    }

    public int getVertices() {
        return vertices;
    }
}
