package com.lynx.lc.c2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. 会议室
 */
public class Lc0252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
