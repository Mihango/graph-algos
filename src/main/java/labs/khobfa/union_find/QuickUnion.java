package labs.khobfa.union_find;

public class QuickUnion implements UnionFind {

    private final int[] ids;
    private int count;

    public QuickUnion(int N) {
        ids = new int[N];
        count = N;
        for (int i = 0; i < N; i++) ids[i] = i;
    }

    private int root(int i) {
        while (i != ids[i]) i = ids[i];
        return i;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP != rootQ) {
            ids[p] = rootQ;
            --count;
        }
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return count;
    }
}
