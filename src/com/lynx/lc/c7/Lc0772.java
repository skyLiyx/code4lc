package com.lynx.lc.c7;

import java.util.ArrayList;
import java.util.List;

/**
 * 772.基本计算器 III
 */
public class Lc0772 {
    private int where;

    public int calculate(String s) {
        where = 0;
        return calculate0(s.toCharArray(), 0);
    }

    private int calculate0(char[] s, int i) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int cur = 0;
        while (i < s.length && s[i] != ')') {
            if (s[i] >= '0' && s[i] <= '9') {
                cur = cur * 10 + (s[i++] - '0');
            } else if (s[i] != '(') {
                // 遇到了运算符
                push(nums, ops, cur, s[i++]);
                cur = 0;
            } else {
                // 遇到了左括号
                cur = calculate0(s, i + 1);
                i = where + 1;
            }
        }
        push(nums, ops, cur, '+');
        where = i;
        return compute(nums, ops);
    }

    private void push(List<Integer> nums, List<Character> ops, int cur, char c) {
        if (ops.isEmpty() || ops.get(ops.size() - 1) == '+' || ops.get(ops.size() - 1) == '-') {
            nums.add(cur);
            ops.add(c);
        } else {
            int last = nums.get(nums.size() - 1);
            char op = ops.get(ops.size() - 1);
            if (op == '*') {
                cur = last * cur;
            } else {
                cur = last / cur;
            }
            nums.set(nums.size() - 1, cur);
            ops.set(ops.size() - 1, c);
        }
    }

    private int compute(List<Integer> nums, List<Character> ops) {
        int ans = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            ans += ops.get(i - 1) == '+' ? nums.get(i) : -nums.get(i);
        }
        return ans;
    }
}
