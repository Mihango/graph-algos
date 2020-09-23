package labs.khobfa.union_find;

public class WeightedQuickUnion implements UnionFind {

    private final int[] ids;
    private final int[] size;
    private int count;


    public WeightedQuickUnion(int N) {
        ids = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < N; i++) ids[i] = i;
    }

    private int root(int i) {
        while (i != ids[i]) {
            // path compression
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
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
            if (size[rootP] < size[rootQ]) {
                ids[p] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                ids[q] = rootP;
                size[rootP] += size[rootQ];
            }
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
