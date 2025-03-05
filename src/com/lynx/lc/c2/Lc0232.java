package com.lynx.lc.c2;

import java.util.Stack;

/**
 * 232.用栈实现队列
 */
public class Lc0232 {

    public static class MyQueue {

        private final Stack<Integer> in;
        private final Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return out.isEmpty() && in.isEmpty();
        }
    }

}
