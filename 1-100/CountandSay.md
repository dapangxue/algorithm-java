# Count and Say
## 示例代码
``` java
class Solution {
    public String countAndSay(int n) {
        StringBuilder previous = new StringBuilder();
        StringBuilder current = new StringBuilder("1");

        int count = 1;

        for (int i = 1; i < n; i++) {
            previous = current;
            count = 1;
            current = new StringBuilder();
            char fix = previous.charAt(0);

            for (int j = 1; j < previous.length(); j++) {
                if (previous.charAt(j) == fix) {
                    count++;
                } else {
                    current.append(count).append(fix);
                    count = 1;
                    fix = previous.charAt(j);
                }
            }
            current.append(count).append(fix);
        }
        return current.toString();
    }
}
```
