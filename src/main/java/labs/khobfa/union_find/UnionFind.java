package labs.khobfa.union_find;

public interface UnionFind {
    boolean isConnected(int p, int q);
    void union(int p, int q);
    int find(int p);
    int count();
}
