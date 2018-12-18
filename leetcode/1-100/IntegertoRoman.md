# 数字转罗马字符串
---
## 思路
题目的要求是把特殊的数字转为对应的字符串，就是把特殊的数字一个个提取出来和特殊数字所对应的字符串相匹配，再将子字符串相加。

## 示例代码
```java
class Solution {
    public String intToRoman(int num) {
        int[] figure = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < figure.length; i++) {
            while (num >= figure[i]) {
                num = num - figure[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
```
