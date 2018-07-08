# Longest Substring Without Repeating Characters
## 思路
建立三个变量`left` `right` `res`分别表示子字符的左边界、右边界和长度，采用右边不断递增的方式判断有没有重复的字符，若有就从左边开始删除。删除完之后再添加新的字符
## 示例代码
``` java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;

        HashSet<Character> hashSet = new HashSet<>();
        while (right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right++));
                res = Math.max(hashSet.size(), res);
            } else {
                hashSet.remove(s.charAt(left++));
            }
        }
        return res;
    }
}
```

``` java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0,res = 0;

        List<Character> list = new ArrayList<>();
        while (right < s.length()) {
            if (!list.contains(s.charAt(right))) {
                list.add(s.charAt(right++));
                res = Math.max(list.size(), res);
            } else {
                // 此处需要做一下强制转换,将char转换为包装类Character
                list.remove((Character)s.charAt(left++));
                // list.remove(0);
            }
        }
        return res;
    }
}
```
