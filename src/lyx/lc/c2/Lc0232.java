package lyx.lc.c2;

import java.util.Stack;

/**
 * 232.用栈实现队列
 */
public class Lc0232 {

    /**
     * 实现原理：
     * <p>准备两个栈，一个作为入队，一个作为出队。
     * 每当执行pop和peek操作时，如果出队栈是空的，那么就将入队栈的所有
     * 元素都弹出并压入入队栈中，这样就实现先入栈的在出队栈的顶部。
     */
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
