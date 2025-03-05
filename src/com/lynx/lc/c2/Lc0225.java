package com.lynx.lc.c2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.用队列实现栈
 */
public class Lc0225 {

    public static class MyStack {
        private final Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.add(x);
            // 每次进入之后，把前面的出一次再进一次
            for (int i = 0; i < n; i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
