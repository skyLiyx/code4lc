package lyx.lc.c3;

/**
 * 374. 猜数字大小
 */
public class Lc0374 {

    public static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int result = guess(mid);
                if (result == 0) {
                    return mid;
                } else if (result == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    /* ****************** for compile correctly ********************/
    static class GuessGame {
        /**
         * Forward declaration of guess API.
         * @param  num   your guess
         * @return -1 if num is higher than the picked number
         * 1 if num is lower than the picked number otherwise
         * return 0.
         */
        native int guess(int num);
    }
    /* ****************** for compile correctly ********************/
}
