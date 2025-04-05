package lyx.lc.c24;

import java.util.ArrayList;
import java.util.List;

/**
 * 2477. 到达首都的最少油耗
 *
 * @apiNote 树形DP
 */
public class Lc2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        long[] cost = new long[n + 1];
        int[] people = new int[n + 1];
        f(graph, seats, 0, -1, cost, people);
        return cost[0];
    }

    /**
     *
     * @param graph  图
     * @param seats  座位数
     * @param u      当前节点
     * @param p      父节点
     * @param cost   到达节点的代价
     * @param people 到达节点的人数
     */
    private void f(List<List<Integer>> graph, int seats, int u, int p, long[] cost, int[] people) {
        people[u] = 1;
        for (int v : graph.get(u)) {
            if (v != p) { // 通过该方式保证只会向下遍历子树
                f(graph, seats, v, u, cost, people);
                // 当前节点获得子节点的人数
                people[u] += people[v];
                // 到达当前节点的消耗 = 到达所有子节点v的消耗 + 所有子节点v到达当前节点的消耗
                cost[u] += cost[v] + (people[v] + seats - 1) / seats;
            }
        }
    }
}
