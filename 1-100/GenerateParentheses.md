# Generate Parentheses
## 思路
本题目采用的递归的思想，用left和right来表示剩余的左右括号数。组成字符串的时候，左边的括号肯定要多于右边的字符串才算合理
## 示例代码
``` java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n, n, "", list);
        return list;
    }

    public void helper(int left, int right, String out, List<String> list) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            list.add(out);
            return;
        }

        helper(left - 1, right, out+"(", list);
        helper(left, right - 1, out+")", list);
    }
}
```
