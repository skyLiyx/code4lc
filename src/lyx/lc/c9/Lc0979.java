package lyx.lc.c9;

import lyx.util.BinaryTree.TreeNode;

/**
 * 979. 在二叉树中分配硬币
 */
public class Lc0979 {
    public int distributeCoins(TreeNode root) {
        return f(root).moves;
    }

    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(0, 0, 0);
        }
        Info leftInfo = f(root.left);
        Info rightInfo = f(root.right);
        int cnt = leftInfo.cnt + rightInfo.cnt + 1;
        int coins = root.val + leftInfo.coins + rightInfo.coins;
        int moves = leftInfo.moves + rightInfo.moves
                + Math.abs(leftInfo.cnt - leftInfo.coins)
                + Math.abs(rightInfo.cnt - rightInfo.coins);
        return new Info(cnt, coins, moves);
    }

    private static class Info {
        public int cnt;
        public int coins;
        public int moves;

        public Info(int cnt, int coins, int moves) {
            this.cnt = cnt;
            this.coins = coins;
            this.moves = moves;
        }
    }
}
