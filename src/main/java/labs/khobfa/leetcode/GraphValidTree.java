package labs.khobfa.leetcode;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */
public class GraphValidTree {
    int[] ids;

    public boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;

        ids = new int[n];

        for (int i = 0; i < n; i++) ids[i] = i;

        int components = n;
        for (int[] edge : edges) {
            if (connected(edge[0], edge[1])) return false;
            union(edge[0], edge[1]);
            components--;
        }

        return components == 1;
    }

    private int find(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void union(int p, int q) {
        int qRoot = find(q);
        int pRoot = find(p);
        ids[pRoot] = qRoot;
    }
}
