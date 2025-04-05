package lyx.lc.c1;

import java.util.*;

/**
 * 126. 单词接龙 II
 *
 * @apiNote BFS + DFS
 */
public class Lc0126 {
    // 构建图
    private static final Map<String, List<String>> graph = new HashMap<>();

    // 字典集：去重+查找优化
    private static final Set<String> words = new HashSet<>();

    // 广搜当前层
    private static final Set<String> curLevel = new HashSet<>();

    // 广搜下一层
    private static final Set<String> nextLevel = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        build(wordList);
        if (!words.contains(endWord)) {
            return ans;
        }
        // 先通过广度优先遍历构建图
        // 再通过深度优先遍历找出路径
        if (bfs(beginWord, endWord)) {
            dfs(ans, new LinkedList<>(), endWord, beginWord);
        }
        return ans;
    }

    private void build(List<String> wordList) {
        graph.clear();
        words.clear();
        words.addAll(wordList);
        curLevel.clear();
        nextLevel.clear();
    }

    private boolean bfs(String beginWord, String endWord) {
        curLevel.add(beginWord);
        // 是否找到目标字符
        boolean found = false;
        while (!curLevel.isEmpty()) {
            // 通过从set中移出当前层元素，来替代标记已访问
            words.removeAll(curLevel);
            for (String word : curLevel) {
                // 遍历每个元素，将其每个位置的字母依次替换成除其之外的其他字母
                // 找字典集中是否存在，存在那么就是一条路径，将其加入图中
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        arr[i] = ch;
                        String replacement = String.valueOf(arr);
                        if (words.contains(replacement)) {
                            if (replacement.equals(endWord)) {
                                found = true;
                            }
                            graph.putIfAbsent(replacement, new ArrayList<>());
                            graph.get(replacement).add(word);
                            nextLevel.add(replacement);
                        }
                    }
                    arr[i] = old;
                }
            }
            if (found) {
                return true;
            }
            curLevel.clear();
            curLevel.addAll(nextLevel);
            nextLevel.clear();
        }
        return false;
    }

    private void dfs(List<List<String>> ans, Deque<String> path, String cur, String target) {
        path.addFirst(cur);
        if (cur.equals(target)) {
            ans.add(new ArrayList<>(path));
            path.remove(cur);
            return;
        }
        for (String next : graph.get(cur)) {
            dfs(ans, path, next, target);
        }
        path.removeFirst();
    }
}
