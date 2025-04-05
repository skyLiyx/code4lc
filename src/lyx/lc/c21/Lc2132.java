package lyx.lc.c21;

/**
 * 2132. 用邮票贴满网格图
 *
 * @apiNote 二维前缀和 + 二维差分
 */
public class Lc2132 {
    private int m;

    private int n;

    private int h;

    private int w;

    private int[][] sum;

    private int[][] diff;

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        // 初始化
        m = grid.length;
        n = grid[0].length;
        h = stampHeight;
        w = stampWidth;
        sum = new int[m + 1][n + 1];
        diff = new int[m + 2][n + 2];
        buildSum(grid);
        for (int a = 1, c = a + h - 1; c <= m; a++, c++) {
            for (int b = 1, d = b + w - 1; d <= n; b++, d++) {
                if (sumRegion(sum, a, b, c, d) == 0) {
                    // 以当前为起点可以放下地毯，那么构建一个二维差分数组
                    add(a, b, c, d);
                }
            }
        }
        // 将二维差分数组求前缀和，然后确保原数组所有0位置都有增量即可
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                diff[i][j] = diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1] + diff[i][j];
                if (grid[i - 1][j - 1] == 0 && diff[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void buildSum(int[][] grid) {
        // 构建二维数组和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
    }

    private int sumRegion(int[][] sum, int a, int b, int c, int d) {
        return sum[c][d] - sum[a - 1][d] - sum[c][b - 1] + sum[a - 1][b - 1];
    }

    private void add(int a, int b, int c, int d) {
        diff[a][b] += 1;
        diff[c + 1][d + 1] += 1;
        diff[c + 1][b] -= 1;
        diff[a][d + 1] -= 1;
    }
}
