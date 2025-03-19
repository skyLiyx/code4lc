# code4lc

# 概述

这里记录了[leetcode](https://leetcode.cn)上算法题库的题解，同时记录了一些算法。

# 题目分类

- [递归](#递归)
- [前缀信息构建](#前缀信息构建)
- [一维差分与等差数列差分](#一维差分与等差数列差分)
- [二维前缀和与二维差分](#二维前缀和与二维差分)
- [滑动窗口](#滑动窗口)
- [双指针](#双指针)
- [DFS](#DFS)
- [前缀树](#前缀树)
- [数据结构设计](#数据结构设计)
- [二分查找](#二分查找)
- [单调栈](#单调栈)
- [单调队列](#单调队列)
- [并查集](#并查集)
- [动态规划](#动态规划)

### 递归

- 394.字符串解码
- 726.原子的数量
- 772.基本计算器 III

### 前缀信息构建

- 325.和等于 k 的最长子数组长度
- 523.连续的子数组和
- 560.和为 K 的子数组
- 974.和可被 K 整除的子数组
- 1124.表现良好的最长时间段
- 1371.每个元音包含偶数次的最长子字符串
- 1590.使数组和能被 P 整除
- 1814.统计一个数组中好对子的数目
- 2121.相同元素的间隔之和
- 2364.统计坏数对的数目

### 一维差分与等差数列差分

- 1109.航班预订统计

### 二维前缀和与二维差分

- 304.二维区域和检索 - 矩阵不可变
- 1139.最大的以 1 为边界的正方形
- 2132.用邮票贴满网格图

### 滑动窗口

- 3.无重复字符的最长子串
- 76.最小覆盖子串
- 134.加油站
- 209.长度最小的子数组
- 395.至少有 K 个重复字符的最长子串
- 713.乘积小于 K 的子数组
- 992.K 个不同整数的子数组
- 1234.替换子串得到平衡字符串

### 双指针

- 11.盛最多水的容器
- 41.缺失的第一个正数
- 42.接雨水
- 287.寻找重复数
- 475.供暖器
- 881.救生艇
- 922.按奇偶排序数组 II

### DFS

- 46.全排列
- 47.全排列 II
- 51.N皇后
- 52.N皇后 II
- 78.子集
- 79.单词搜索
- 90.子集 II

### 前缀树

- 212.单词搜索 II
- 421.数组中两个数的最大异或值

### 数据结构设计

- 155.最小栈
- 225.用队列实现栈
- 232.用栈实现队列
- 622.设计循环队列
- 641.设计循环双端队列
- 707.设计链表
- 1804.实现Trie（前缀树）

### 二分查找

- 410.分割数组的最大值
- 719.找出第K小的数对距离
- 875.爱吃香蕉的珂珂
- 2141.同时运行 N 台电脑的最长时间

### 单调栈

- 84.柱状图中最大的矩形
- 85.最大矩形
- 316.去除重复字母
- 321.拼接最大数
- 402.移掉 K 位数字
- 739.每日温度
- 907.子数组的最小值之和
- 962.最大宽度坡
- 1081.不同字符的最小子序列
- 1504.统计全 1 子矩形

### 单调队列

- 239.滑动窗口最大值
- 862.和至少为 K 的最短子数组
- 1438.绝对差不超过限制的最长连续子数组
- 1499.满足不等式的最大值
- 2398.预算内的最多机器人数目

### 并查集

- 200.岛屿数量
- 765.情侣牵手
- 839.相似字符串组
- 924.尽量减少恶意软件的传播
- 928.尽量减少恶意软件的传播 II
- 947.移除最多的同行或同列石头
- 2092.找出知晓秘密的所有专家
- 2421.好路径的数目

### 动态规划

- 62.不同路径
- 63.不同路径II
- 64.最小路径和
- 70.爬楼梯
- 120.三角形最小路径和
- 198.打家劫舍
- 221.最大正方形
- 509.斐波那契数
- 740.删除并获得点数
- 746.使用最小花费爬楼梯
- 931.下降路径最小和
- 1137.第N个泰波那契数

# 算法

### 字符串

* [Manacher](./src/com/lynx/algo/string/Manacher.java) - 最长回文子串
* [KMP](./src/com/lynx/algo/string/Kmp.java) - 字符串匹配
* [前缀树 (Trie)](./src/com/lynx/algo/string/Trie.java) - 字符串统计
