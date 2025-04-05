package lyx.lc.c20;

import java.util.Arrays;

/**
 * 2071. 你可以安排的最多任务数目
 *
 * @apiNote 二分查找 + 贪心 + 双端队列
 */
public class Lc2071 {
    private final int[] deque = new int[50001];
    private int h, t;
    private int[] tasks;
    private int[] workers;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        int taskCount = tasks.length, workerCount = workers.length;
        int l = 0, r = Math.min(taskCount, workerCount), m;
        int ans = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            // m是当前一定要处理的任务数量
            // 用力量最大的m个工人处理力量要求最小的m个任务(贪心)
            if (check(0, m - 1, workerCount - m, workerCount - 1, pills, strength)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private boolean check(int tl, int tr, int wl, int wr, int pills, int strength) {
        h = t = 0;
        int count = 0;
        for (int i = wl, j = tl; i <= wr; i++) {
            // 当前来到第i个工人
            while (j <= tr && tasks[j] <= workers[i]) {
                // 可以解锁的任务
                deque[t++] = tasks[j++];
            }
            if (h < t && deque[h] <= workers[i]) {
                // 可以处理任务，处理头部任务(贪心)
                h++;
            } else {
                // 如果当前工人没有能做的任务，吃药丸
                while (j <= tr && tasks[j] <= workers[i] + strength) {
                    // 吃药之后可以解锁的任务
                    deque[t++] = tasks[j++];
                }
                if (h == t || deque[h] > workers[i] + strength) {
                    // 吃了药丸还是没有任务或者无法处理，肯定不能完成m个任务了
                    return false;
                } else {
                    // 吃了药丸就处理尾部任务(贪心)
                    t--;
                    count++;
                }
            }
        }
        return count <= pills;
    }
}
