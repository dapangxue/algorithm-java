# 最长的公共字符串
## 思路
假设数组的第一个元素为最长的公共子字符串，将它和剩余的数组元素比较，判断是否是公共字符串。

## 示例代码
```java
class solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++){
            // 只能是-1或者0
            while (strs[i].index(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
```
