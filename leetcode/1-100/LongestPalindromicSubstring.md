# 查找最长的回文子字符串
------
## 思路
1. 回文字符串左右对称，必有一个字符或者两个字符为它的中心，从这个中心开始，往左或者往右移动相同的位置，对应的字符一定相等。
2. 给定一个字符串，从头到尾遍历它，以第i个字符（回文子字符串的长度为奇数），或者第i和第i+1个字符（回文子字符串长度为偶数）为回文子字符串的中心，分别进行判断。

## 示例代码
``` java
class Solution {
    public String longestPalindrome(String s) {
        int len1 = 0;
        int len2 = 0;
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 计算长度为奇数的回文子字符串的长度
            len1 = lengthPalindromicSubstring(s, i, i);
            // 计算长度为偶数的回文子字符串的长度
            len2 = lengthPalindromicSubstring(s, i, i + 1);
            // 比较两个字符串的长度
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int lengthPalindromicSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```
