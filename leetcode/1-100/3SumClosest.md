# 最近三数之和
## 思路
本题和三数之和那题类似，只不过需要把绝对值差保存下来。
## 示例代码
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1.设定初始情况
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);

        // 2.数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;    
                }
                if (sum < target) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return closest;
    }
}
```
