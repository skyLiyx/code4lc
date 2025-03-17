package com.lynx.lc.c7;

/**
 * 739. 每日温度
 *
 * @apiNote 单调栈
 */
public class Lc0739 {

    private final int[] stack = new int[100000];

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0, size = 0, cur; i < n; i++) {
            while (size > 0 && temperatures[i] > temperatures[stack[size - 1]]) {
                cur = stack[--size];
                ans[cur] = i - cur;
            }
            stack[size++] = i;
        }
        return ans;
    }
}
