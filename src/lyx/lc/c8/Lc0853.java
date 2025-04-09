package lyx.lc.c8;

import java.util.Arrays;

/**
 * 853. 车队
 *
 * @apiNote 单调栈
 */
public class Lc0853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (c1, c2) -> c2[0] - c1[0]);
        double[] cost = new double[n];
        for (int i = 0; i < n; i++) {
            cost[i] = (double) (target - cars[i][0]) / cars[i][1];
        }
        double[] stack = new double[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            double cur = cost[i];
            while (size > 0 && cur <= stack[size - 1]) {
                // 追上之后变成那个车
                cur = stack[--size];
            }
            stack[size++] = cur;
        }
        return size;
    }
}
