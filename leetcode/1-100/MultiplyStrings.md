# Multiply Strings
本题参考了[JustDoIT](http://www.cnblogs.com/TenosDoIt/p/3735309.html)的博客思路
## 示例代码
``` java
class Solution {
    public String multiply(String num1, String num2) {
        int[] fix = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                fix[i+j+1] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int carry = 0;
        for (int i = fix.length-1; i >0; i--) {
            carry = fix[i]/10;
            fix[i-1] = fix[i-1] + carry;
            fix[i] = fix[i]%10;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int k : fix) {
            stringBuilder.append(k);
        }
        while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.length() == 0? "0":stringBuilder.toString();
    }
}
```
