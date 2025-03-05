package com.lynx.lc.c1;

/**
 * 155.最小栈
 */
public class Lc0155 {

    /**
     * 实现原理：
     * <p>定义两个栈，一个存数据，一个存当前最小值。每次入栈时操作两个栈：
     * <pre>
     *     1、将数据正常压入数据栈；
     *     2、比较数据和最小值栈栈顶值的大小，压入较小的那个数到最小值栈。
     * </pre>
     */
    public static class MinStack {
        int[] data;
        int[] min;
        int size;

        public MinStack() {
            data = new int[30001];
            min = new int[30001];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || min[size - 1] > val) {
                min[size] = val;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }

}
