package com.lynx.lc.c0;

/**
 * 12. 整数转罗马数字
 */
public class Lc0012 {
    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            while (num >= 1000) {
                num -= 1000;
                sb.append("M");
            }
        } else if (num >= 900) {
            sb.append("CM");
            num -= 900;
        } else if (num >= 500) {
            sb.append("D");
            num -= 500;
        } else if (num >= 400) {
            sb.append("CD");
            num -= 400;
        } else if (num >= 100) {
            while (num >= 100) {
                num -= 100;
                sb.append("C");
            }
        } else if (num >= 90) {
            sb.append("XC");
            num -= 90;
        } else if (num >= 50) {
            sb.append("L");
            num -= 50;
        } else if (num >= 40) {
            sb.append("XL");
            num -= 40;
        } else if (num >= 10) {
            while (num >= 10) {
                num -= 10;
                sb.append("X");
            }
        } else if (num == 9) {
            sb.append("IX");
            return sb.toString();
        } else if (num >= 5) {
            sb.append("V");
            num -= 5;
        } else if (num == 4) {
            sb.append("IV");
            return sb.toString();
        } else {
            while (num >= 1) {
                num -= 1;
                sb.append("I");
            }
        }
        sb.append(intToRoman(num));
        return sb.toString();
    }
}
