# Z字形变换
------
## 思路
1. 题目的要求是将输入的一串字符串先变换为Z字形的字符串，再逐行输出。
2. 题目要求的`numRows`可以确定Z字形字符串的行数为`numRows`行。
3. 最后再将Z字形字符串的结果输出。

例如输入一串字符串`ABCDEFGHI`, `numRows`为3。可知最后结果输出3行，可以将Z字形字符串结果想象为多个单元组成在一起，比如下面结果的`ABCD`为一个单元，观察可知每个单元的长度`size`为`2*numRows-2`,即不包括Z字形状的第一行和最后一行。

变换为Z字形字符串的的结果如下：
```
A   E   I
B D F H
C   G
```
## 示例代码
```java
class Solution {
    public String convert(String s, int numRows) {

        if (s == null || numRows <=0 || s.length() == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder newString = new StringBuilder();
        int size = 2*numRows - 2;

        // 逐行遍历，符合条件的字符插入StringBuilder
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j+=size) {
                newString.append(s.charAt(j));
                if (i != 0 && i != numRows-1) {
                    int temp = j + size - 2*i;
                    if (temp < s.length()) {
                         newString.append(s.charAt(temp));
                    }
                }
            }
        }
        return newString.toString();
    }
}
```
