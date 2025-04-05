package lyx.lc.c12;

/**
 * 1278.分割回文串 III
 *
 * @date 2025/03/03
 */
public class Lc1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][][] dp = new int[n + 1][n + 1][k + 1];
        // 初始化
        for (int start = 0; start <= n; start++) {
            for (int count = 0; count <= k; count++) {
                dp[start][n][count] = -1;
            }
        }
        for (int start = 0; start <= n; start++) {
            for (int cur = 0; cur < n; cur++) {
                dp[start][cur][1] = minCount(s, start, n - 1);
            }
        }
        // 由于递归版本中start和cur都是递增的，即小的依赖大的，所以倒序遍历
        // cur = n已经初始化过，所以从n-1开始
        // 而递归版本中根据调用情况start肯定小于等于cur，所以也是n-1开始
        for (int start = n - 1; start >= 0; start--) {
            for (int cur = n - 1; cur >= 0; cur--) {
                // 由于递归版本中count是递减的，即大的依赖小的，所以正序遍历
                // count = 1已经初始化过，从2开始
                for (int count = 2; count <= k; count++) {
                    // int notCut = process(s, start, cur + 1, count, dp);
                    // int cut = process(s, cur + 1, cur + 1, count - 1, dp);
                    // 直接替换递归版本的方法调用，转而用可变参数来获取dp数组的缓存
                    int notCut = dp[start][cur + 1][count];
                    int cut = dp[cur + 1][cur + 1][count - 1];
                    // 剩下的我直接哈哈哈哈拷贝过来就是了啊，居然这么简单我哭死！！！
                    if (notCut == -1 && cut == -1) {
                        dp[start][cur][count] = -1;
                    } else if (cut == -1) {
                        dp[start][cur][count] = notCut;
                    } else {
                        int minCount = minCount(s, start, cur);
                        if (notCut == -1) {
                            dp[start][cur][count] = minCount + cut;
                        } else {
                            dp[start][cur][count] = Math.min(minCount + cut, notCut);
                        }
                    }
                }
            }
        }
        // 返回目标位置的值
        return dp[0][0][k];
    }

    /**
     * 暴力递归 + 记忆化搜索的参考版本。主方法直接调process(s, 0, 0, k, dp)即可。
     *
     * @param s     字符串，固定参数
     * @param start 当前子串起始位置，根据调用情况，不可能大于cur
     * @param cur   当前位置，根据调用情况，不可能大于字符串的长度
     * @param count 分割块数
     * @param dp    记忆缓存数组
     * @return 最小修改字符数
     */
    private int process(String s, int start, int cur, int count, int[][][] dp) {
        if (dp[start][cur][count] != -2) {
            return dp[start][cur][count];
        }
        if (cur == s.length()) {
            dp[start][cur][count] = -1;
            return dp[start][cur][count];
        }
        if (count == 1) {
            // 只要一块，直接计算整体
            dp[start][cur][count] = minCount(s, start, s.length() - 1);
            return dp[start][cur][count];
        }
        // 分在当前位置不切与切两种情况
        // 不切：当前位置+1，其余不变
        int notCut = process(s, start, cur + 1, count, dp);
        // 切：起点位置变成下一位置，当前位置+1，分割块数减少1个
        // 然后在切之后剩余范围内存在合法情况的时候，计算当前切出这块的最小修改字符数
        // 而当前切之后的最小值就是当前子块的最小值 + 剩余情况的值
        int cut = process(s, cur + 1, cur + 1, count - 1, dp);
        if (notCut == -1 && cut == -1) {
            // 不管切与否，到了这个位置时都没有满足条件的情况了，返回一个非法值
            dp[start][cur][count] = -1;
        } else if (cut == -1) {
            // 只有切的情况不合法，只能取不切的值
            dp[start][cur][count] = notCut;
        } else {// 计算当前切出这块的最小修改字符数
            int minCount = minCount(s, start, cur);
            if (notCut == -1) {
                // 只有不切的情况不合法，只能取切的值
                dp[start][cur][count] = minCount + cut;
            } else {
                // 切和不切都满足条件，取两者中较小的值
                dp[start][cur][count] = Math.min(minCount + cut, notCut);
            }
        }
        return dp[start][cur][count];
    }

    private int minCount(String s, int start, int end) {
        int ans = 0;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                ans++;
            }
        }
        return ans;
    }
}
