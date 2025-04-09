package lyx.lc.c22;

import java.util.Arrays;

/**
 * 2271. 毯子覆盖的最多白色砖块数
 */
public class Lc2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (t1, t2) -> t1[0] - t2[0]);
        int n = tiles.length;
        int ans = 0;
        int cover = 0, uncover;
        for (int l = 0, r = 0; r < n; r++) {
            // right瓷砖组滑入，加上长度
            cover += tiles[r][1] - tiles[r][0] + 1;
            // 当前毯子的位置 [ tiles[r][1] - carpetLen + 1, tiles[r][1] ]
            // left瓷砖组的右端点不在窗口下，滑出
            while (tiles[l][1] < tiles[r][1] - carpetLen + 1) {
                cover -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }
            // left瓷砖组可能没有被全部覆盖
            uncover = Math.max(0, (tiles[r][1] - carpetLen + 1) - tiles[l][0]);
            ans = Math.max(ans, cover - uncover);
        }
        return ans;
    }
}
