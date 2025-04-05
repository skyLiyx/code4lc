package lyx.lc.c25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2506.统计相似字符串对的数目
 *
 * @date 2025/02/22
 */
public class Lc2506 {
    public int similarPairs(String[] words) {
        // 每个字符串的掩码，其二进制从右往左依次表示是'a'到'z'是否出现
        // 每个字符串的掩码
        int res = 0;
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (byte b : words[i].getBytes()) {
                masks[i] |= (1 << (b - 'a'));
            }
            for (int j = 0; j < i; j++) {
                if (masks[i] == masks[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
