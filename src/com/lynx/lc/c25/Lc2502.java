package com.lynx.lc.c25;

/**
 * 2502.设计内存分配器
 *
 * @date 2025/02/25
 */
public class Lc2502 {

    public static class Allocator {
        int[] arr; // 存放数据, arr[i]到arr[i + len[i] - 1]范围内都是arr[i]数据
        int[] len; // 存放数据长度, len[i]不等于0才有效, 表示arr[i]数据的长度

        public Allocator(int n) {
            arr = new int[n]; // 初始化默认都是0
            len = new int[n];
            len[0] = n; // 初始arr[0]数据的长度就是n
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < arr.length; i += len[i]) {
                if (arr[i] == 0 && len[i] >= size) {
                    // 当前下标为0且其长度不小于size时，可以存下mID
                    if (i + size < arr.length && arr[i + size] == 0) {
                        // 塞下mID后还剩有空间，更新剩下空间的长度
                        len[i + size] = len[i] - size;
                    }
                    arr[i] = mID;
                    len[i] = size;
                    return i;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int res = 0;
            for (int i = 0; i < arr.length; i += len[i]) {
                if (arr[i] == mID) {
                    res += len[i];
                    arr[i] = 0;
                }
            }
            // 将删除数据后更新为0的区间和其相邻的本来为0的区间合并
            for (int i = 0; i < arr.length; i += len[i]) {
                if (arr[i] == 0) {
                    int j = i + len[i];
                    while (j < arr.length && arr[j] == 0) {
                        j += len[j];
                    }
                    len[i] = j - i;
                }
            }
            return res;
        }
    }
}
