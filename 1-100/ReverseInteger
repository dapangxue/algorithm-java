# 数字反转
------
## 思路
1. 操作字符串，先将数字转换为字符串反转后再转换为数字
2. 普通思路：求除求余，要判断反转的后的数字是否越界

## 示例代码
### 方法一
```java
class Solution {
    public int reverse(int x) {
        // 去掉正负号转换为字符串
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(Math.abs(x)));
        try {
            String stringReverse = stringBuilder.reverse().toString();
            return Integer.parseInt(stringReverse.replaceFirst("^0+(?!$)", ""))*(x/Math.abs(x));
        } catch (Exception e) {
            return 0;
        }
    }
}
```
### 方法二
```java
class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            // 取x的末尾数
            int tail = x%10;
            result = result*10 + tail;
            // 查看result是否越界int
            if (result < -0x80000000 || result > 0x7fffffff) {
                return 0;
            }
            x = x/10;
        }
    }
}
```
### 方法三
```java
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // 取x的末尾数
            int tail = x%10;
            int newResult = result*10 + tail;
            // 查看newResult是否越界
            if (result != (newResult-tail)/10) {
                return 0;
            }
            result = newResult;
            x = x/10;
        }
        return result;
    }
}
```
