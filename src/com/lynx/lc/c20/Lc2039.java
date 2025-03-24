package com.lynx.lc.c20;

import java.util.Arrays;

/**
 * 2039. 网络空闲的时刻
 *
 * @apiNote 最短路径 / Dijkstra 算法 + 反向索引堆
 */
public class Lc2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        build(n);
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }
        dijkstra();
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            int receiveTime = distance[i] * 2;
            int retryTimes = (receiveTime - 1) / patience[i - 1];
            ans = Math.max(ans, retryTimes * patience[i - 1] + receiveTime);
        }
        return ans + 1;
    }

    private void dijkstra() {
        addOrUpdateOrIgnore(1, 0);
        while (heapSize > 0) {
            int u = pop();
            for (int ei = head[u]; ei > 0; ei = next[ei]) {
                addOrUpdateOrIgnore(to[ei], distance[u] + 1);
            }
        }
    }

    private void addOrUpdateOrIgnore(int v, int c) {
        if (where[v] == -1) {
            // 第一次加入
            distance[v] = c;
            heap[heapSize] = v;
            where[v] = heapSize++;
            heapInsert(where[v]);
        } else if (where[v] >= 0) {
            if (c < distance[v]) {
                distance[v] = c;
                heapInsert(where[v]);
            }
        }
    }

    private static final int MAXN = 100001;

    // 链式前向星
    private static final int[] head = new int[MAXN];
    private static final int[] next = new int[MAXN << 1];
    private static final int[] to = new int[MAXN << 1];
    private static int cnt;

    // 反向索引堆
    private static final int[] heap = new int[MAXN];
    private int heapSize;
    private static final int[] where = new int[MAXN];

    private static final int[] distance = new int[MAXN];

    private void build(int n) {
        cnt = 1;
        Arrays.fill(head, 0, n + 1, 0);
        heapSize = 0;
        Arrays.fill(where, 0, n + 1, -1);
    }

    private void addEdge(int u, int v) {
        u++;
        v++;
        next[cnt] = head[u];
        to[cnt] = v;
        head[u] = cnt++;
    }

    private int pop() {
        int ans = heap[0];
        swap(0, --heapSize);
        heapify();
        where[ans] = -2;
        return ans;
    }

    private void heapInsert(int index) {
        while (distance[heap[index]] < distance[heap[(index - 1) / 2]]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify() {
        int i = 0;
        int j = 1;
        while (j < heapSize) {
            int best = j + 1 < heapSize && distance[heap[j + 1]] < distance[heap[j]] ? j + 1 : j;
            best = distance[heap[best]] < distance[heap[i]] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            j = i * 2 + 1;
        }
    }

    private void swap(int i, int j) {
        where[heap[i]] = j;
        where[heap[j]] = i;
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
