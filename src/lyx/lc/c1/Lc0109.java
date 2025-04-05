package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;
import lyx.util.SinglyLinkedList.ListNode;

/**
 * 109.有序链表转换二叉搜索树
 */
public class Lc0109 {
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        return buildBST(0, n - 1);
    }

    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode left = buildBST(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = buildBST(mid + 1, end);
        return root;
    }
}
