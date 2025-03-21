package com.lynx.lc.c3;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. 日志速率限制器
 */
public class Lc0359 {

    public static class Logger {
        private final Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message) && timestamp - map.get(message) < 10) {
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }
}
