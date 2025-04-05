package lyx.lc.c12;

import java.util.Random;

/**
 * 1206.设计跳表
 *
 * @date 2025/02/23
 */
public class Lc1206 {

    /**
     * INTRO:<br/>
     * Chinese version: <a href="https://oi-wiki.org/ds/skiplist/">跳表 - OI Wiki</a><br/>
     * English version: <a href="https://www.geeksforgeeks.org/skip-list/">
     *     Skip List - Efficient Search, Insert and Delete in Linked List</a>
     */
    public static class Skiplist {

        private static final int MAX_LEVEL = 1 << 5;

        private static final double P_LEVEL = 0.25d;

        private int currentLevel;

        private final Node head;

        private final Random random = new Random();

        public Skiplist() {
            this.head = new Node(-1, MAX_LEVEL);
            this.currentLevel = 1;
        }

        public boolean search(int target) {
            Node cur = this.head;
            // 从上往下跳
            for (int i = this.currentLevel - 1; i >= 0; i--) {
                // 向右跳到目标节点的最左边
                while (cur.next[i] != null && cur.next[i].val < target) {
                    cur = cur.next[i];
                }
                // 当前层中靠近新节点最左边的节点
                // 判断next是否是目标值
                if (cur.next[i] != null && cur.next[i].val == target) {
                    return true;
                }
                // 不是，跳下一层继续找
            }
            return false;
        }

        public void add(int num) {
            // 生成一个随机数作为新节点的层数
            int level = this.randomLevel();
            Node newNode = new Node(num, level);
            Node cur = this.head;
            for (int i = this.currentLevel - 1; i >= 0; i--) {
                while (cur.next[i] != null && cur.next[i].val < num) {
                    cur = cur.next[i];
                }
                // 当前层中靠近新节点最左边的节点
                // 如果比新节点矮，连接next
                if (i < level) {
                    newNode.next[i] = cur.next[i];
                    cur.next[i] = newNode;
                }
            }
            // 更新新节点的层数
            if (level > this.currentLevel) {
                for (int i = this.currentLevel; i < level; i++) {
                    head.next[i] = newNode;
                }
                this.currentLevel = level;
            }
        }

        public boolean erase(int num) {
            Node cur = this.head;
            boolean deleted = false;
            for (int i = this.currentLevel - 1; i >= 0; i--) {
                while (cur.next[i] != null && cur.next[i].val < num) {
                    cur = cur.next[i];
                }
                // 找到后修改next指针来删除
                if (cur.next[i] != null && cur.next[i].val == num) {
                    Node delete = cur.next[i];
                    cur.next[i] = delete.next[i];
                    // 释放内存
                    delete.next[i] = null;
                    deleted = true;
                }
            }
            if (deleted) {
                // 删除后，更新层数
                while (this.currentLevel > 1 && this.head.next[this.currentLevel - 1] == null) {
                    this.currentLevel--;
                }
            }
            return deleted;
        }

        private int randomLevel() {
            int randomLevel = 1;
            while (random.nextDouble() < P_LEVEL && randomLevel <= MAX_LEVEL) {
                randomLevel++;
            }
            return randomLevel;
        }

    }

    static class Node {
        int val;
        Node[] next;

        public Node(int value, int level) {
            this.val = value;
            this.next = new Node[level];
        }
    }

}
