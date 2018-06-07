# 回文数字
---
## 思路
### 思路1
1. 如果传进来的整数为负数，则它一定不是回文数字
2. 如果是正数，可以把它先转化为字符串，再利用StringBuilder的reverse()方法，判断反转后是否相等

### 思路2
1. 如果传进来的整数为负数，则它一定不是回文数字
2. 循环求正整数对10的余数，将整个整数反转，比较是否相等

## 示例代码
### 方法一
>StringBuilder的关于相等的比较暂时还没搞清楚,所以这里先将它们转为String来操作

```java
class Solution {
    public boolean isPalindrome(int x) {
        // 先将数字转为字符串
        String str = String.valueOf(x);
        // 1. 首先判断转为字符串的第一位字符是否为'-'
        // 若数字前带有正号，则正号在转为字符串过程中已经去掉
        if (str.charAt(0) == '-') {
            return false;
        }
        // 2. 将字符串转为StringBuilder,利用StringBuilder的reverse()函数
        StringBuilder sb = new StringBuilder(str);
        if (sb.toString().equals(sb.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
}
```
### 方法二
```java
class Solution {
    public boolean isPalindrome(int x) {
        int input = x, rev = 0;
        // 1.判断是否是负数
        if (x < 0) {
            return false;
        }
        // 2.将数字反转
        while (x != 0) {
            rev = rev*10 + x%10;
            x/=10;
        }
        if (input == rev) {
            return true;
        } else {
            return false;
        }
    }
}
```
