package labs.khobfa.union_find;

public class QuickFind implements UnionFind {
    private final int[] ids;
    private int count;

    public QuickFind(int N) {
        count = N;
        ids = new int[N];

        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        if (isValid(p) && isValid(q)) return ids[p] == ids[q];
        return false;
    }

    @Override
    public void union(int p, int q) {
        if (!isValid(p) || !isValid(q)) return;

        int pId = find(p);
        int qId = find(q);

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) ids[i] = qId;
        }

        if (pId != qId) --count;
    }

    @Override
    public int find(int p) {
        return isValid(p) ? ids[p] : -1;
    }

    private boolean isValid(int p) {
        return p >= 0 && p < ids.length;
    }

    @Override
    public int count() {
        return count;
    }
}
