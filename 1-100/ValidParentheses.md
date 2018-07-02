# Valid Parentheses
## 思路
采用堆栈的思想，碰到左括号，就`push`右括号入栈，再`pop`其右括号是否匹配
## 示例代码
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        stack.empty();
    }
}
```
