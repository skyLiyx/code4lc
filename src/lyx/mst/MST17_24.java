package lyx.mst;

import java.util.Arrays;

/**
 * 面试题 17.24. 最大子矩阵
 */
public class MST17_24 {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[n]; // 压缩数组
        int globalMax = Integer.MIN_VALUE;
        int a = 0, b = 0, c = 0, d = 0;
        // 以up作为第一行，down作为最后一行
        // 通过压缩数组，以一维数组形式计算子矩阵的累加和
        for (int up = 0; up < m; up++) {
            Arrays.fill(arr, 0);
            for (int down = up; down < m; down++) {
                for (int l = 0, r = 0, preMax = Integer.MIN_VALUE; r < n; r++) {
                    arr[r] += matrix[down][r];
                    if (preMax < 0) {
                        preMax = arr[r];
                        l = r;
                    } else {
                        preMax += arr[r];
                    }
                    if (preMax > globalMax) {
                        globalMax = preMax;
                        a = up;
                        b = l;
                        c = down;
                        d = r;
                    }
                }
            }
        }
        return new int[]{a, b, c, d};
    }
}
