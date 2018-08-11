# Simplify Path
关键词：`字符串拆分`、`栈`、`Stack转List`
## 示例代码
``` java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] fix = path.split("/");
        for (String x : fix) {
            if (!x.equals(".") && !x.equals("") && !x.equals("..")) {
                stack.push(x);
            } else if (!stack.isEmpty() && x.equals("..")) {
                stack.pop();
            }
        }
        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/", list);
    }
}
```
