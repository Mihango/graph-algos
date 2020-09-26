package labs.khobfa.hacker_rank;

import java.util.ArrayList;
import java.util.List;

public class CitiesAndLibraries {

    public long findMinCostOfRoadsAndLib(int n, int c_lib, int c_road, int[][] cities) {
        if (n == 0) return 0;
        if (cities == null || cities.length < 1 || c_road >= c_lib) return n * c_lib;

        // graph
        List<Integer>[] roads = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < cities.length; i++) {
            roads[cities[i][0]].add(cities[i][1]);
            roads[cities[i][1]].add(cities[i][0]);
        }

        // count components and roads int it
        List<Integer> connected = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                connected.add(dfs(i, visited, roads));
        }

        long minCost = 0;
        for (int component : connected) {
            minCost += (component - 1) * c_road + c_lib;
        }
        return minCost;
    }


    private int dfs(int city, boolean[] visited, List<Integer>[] roads) {
        if (visited[city]) return 0;
        visited[city] = true;
        int cc = 1;
        for (int n : roads[city]) {
            if (!visited[n])
                cc += dfs(n, visited, roads);
        }
        return cc;
    }
}
