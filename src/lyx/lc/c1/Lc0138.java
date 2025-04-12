package lyx.lc.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 */
public class Lc0138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node virtual = new Node(0);
        Node deepCopy = virtual;
        Node original = head;
        while (original != null) {
            deepCopy.next = new Node(original.val);
            map.put(original, deepCopy.next); // 老的映射新的
            original = original.next;
            deepCopy = deepCopy.next;
        }
        original = head;
        while (original != null) {
            // 当前节点的深拷贝节点的随机指针，指向当前节点的随机指向节点的深拷贝节点
            map.get(original).random = map.get(original.random);
            original = original.next;
        }
        return virtual.next;
    }

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
