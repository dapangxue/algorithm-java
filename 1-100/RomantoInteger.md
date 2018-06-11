# 罗马字符串转为整形数字
---
## 思路
判断字符串这一位的字符和下一位的字符对应的map的值，如果第`i`为的map值大于第`i+1`位的map值，则字符串下标进1，否则进2。

## 示例代码
### 方法一
```java
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        Map<Character, Integer> map = new HashMap();

        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        for (int i = 0; i < s.length(); ) {
            if (i == s.length()-1) {
                total = total + map.get(s.charAt(i));
                break;
            } else if (i > s.length()-1) {
                break;
            }
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
                total = total + map.get(s.charAt(i));
                i++;
            } else {
                total = total + map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i+=2;
            }
        }
        return total;
    }
}
```
### 方法二
```java
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        Map<Character, Integer> map = new HashMap();

        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i-1)) >= map.get(s.charAt(i))) {
                total += map.get(s.charAt(i-1));
            } else {
                total -= map.get(s.charAt(i-1));
            }
        }
        return total + map.get(s.charAt(s.length()-1));
    }
}
```
