# 字符串转为整数
------
## 思路

## 示例代码
```java
class Solution {
    public int myAtoi(String str) {
        // 定义字符串初始索引从0开始
        int index = 0, symbol = 1, digit = 0, total = 0;
        // 去除字符串的前后空字符
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        // 取正负号
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            symbol = str.charAt(0) == '+'? 1 : -1;
            index++;
        }
        while (index < str.length()) {
            digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9){
                break;
            }
            total = total*10 + digit;
            if((Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total) && Integer.MAX_VALUE %10 < digit){
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
            index++;
        }
        return total*symbol;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.myAtoi("2147483646"));
	}
}
```
