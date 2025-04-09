package lyx.lc.c10;

import lyx.util.SinglyLinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 */
public class Lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            while (!stack.isEmpty() && cur.val > stack.peek()[0]) {
                list.set(stack.pop()[1], cur.val);
            }
            stack.push(new int[]{cur.val, index++});
            list.add(0); // 先占位
            cur = cur.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
