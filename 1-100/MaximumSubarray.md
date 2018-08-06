# Maximum Subarray
## 思路
最普通的思路就是遍历数组求出当前和currentSum和以前保存下来的和res相比较，不断保存最大的和。
## 示例代码
``` java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            currentSum = Math.max(currentSum+num, num);
            res = Math.max(res, currentSum);
        }
        return res;
    }
}
```
