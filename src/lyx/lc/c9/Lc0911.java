package lyx.lc.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * 911. 在线选举
 */
public class Lc0911 {

    public static class TopVotedCandidate {

        private final int[] times;
        private final List<Integer> tops = new ArrayList<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            int[] votes = new int[5001];
            int leadPerson = persons[0];
            votes[leadPerson]++;
            tops.add(leadPerson);
            for (int i = 1; i < persons.length; i++) {
                votes[persons[i]]++;
                if (votes[persons[i]] >= votes[leadPerson]) {
                    leadPerson = persons[i];
                }
                tops.add(leadPerson);
            }
        }

        public int q(int t) {
            int l = 0, r = times.length - 1, m;
            int index = -1;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (times[m] <= t) {
                    index = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return tops.get(index);
        }
    }
}
