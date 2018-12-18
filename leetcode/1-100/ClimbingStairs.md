# Climbing Stairs
采用了动态规划思想
## 示例代码
``` java
class Solution {
    public int climbStairs(int n) {
        int[] stair = new int[n+1];
        for (int i = 0; i < stair.length; i++) {
            if (i == 0) {
                stair[i] = 1;
            } else if (i == 1) {
                stair[i] = 1;
            } else {
                stair[i] = stair[i-1] + stair[i-2];
            }
        }
        return stair[n];
    }
}
```
