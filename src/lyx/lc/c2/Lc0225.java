package lyx.lc.c2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.用队列实现栈
 */
public class Lc0225 {

    /**
     * 实现原理：
     * <p>每次进入队列之后，把之前的数据都出一次，再进一次。这样
     * 队尾的元素的总是能到队首，且队列顺序是按照进入顺序倒序排列
     * 的。
     */
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
