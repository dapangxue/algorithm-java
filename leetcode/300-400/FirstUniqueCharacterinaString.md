# First Unique Character in a String
## 示例代码
方法一
``` java
public class Solution {
    public int firstUniqChar(String s) {
        char c;
        int location = s.length();
        for(c = 'a'; c <= 'z'; c++){
            int temp = s.indexOf(c);
            if (temp == -1) continue;
            // 判断字符是否只出现一次
            if (temp == s.lastIndexOf(c)) {
                location = Math.min(temp, location);
            }
        }
        if(location == s.length()) {
            return -1;
        }
        return location;
    }

}
```
方法二
``` java
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), 1);
            } else {
                int count = hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i), ++count);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
```
