package com.lynx.lc.c22;

/**
 * 2296.设计一个文本编辑器
 *
 * @date 2025/02/27
 */
public class Lc2296 {

    public static class TextEditor {

        private final StringBuilder left;
        private final StringBuilder right;

        public TextEditor() {
            left = new StringBuilder();
            right = new StringBuilder();
        }

        public void addText(String text) {
            left.append(text);
        }

        public int deleteText(int k) {
            k = Math.min(k, left.length());
            left.setLength(left.length() - k);
            return k;
        }

        public String cursorLeft(int k) {
            k = Math.min(k, left.length());
            for (int i = 0; i < k; i++) {
                right.append(left.charAt(left.length() - 1));
                left.setLength(left.length() - 1);
            }
            return left.substring(Math.max(0, left.length() - 10));
        }

        public String cursorRight(int k) {
            k = Math.min(k, right.length());
            for (int i = 0; i < k; i++) {
                left.append(right.charAt(right.length() - 1));
                right.setLength(right.length() - 1);
            }
            return left.substring(Math.max(0, left.length() - 10));
        }
    }

}
