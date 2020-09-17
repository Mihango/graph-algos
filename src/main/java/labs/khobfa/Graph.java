package labs.khobfa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    int vertices = 0;
    List<LinkedList<Integer>> data;

    public Graph(int size) {
        this.vertices = size;
        data = new ArrayList<>(vertices);
    }

    public Iterable<Integer> getAdjacent(int x) {
        return data.get(x);
    }
}
