# Search Insert Position
## 示例代码
``` java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int dummy = 0;
        if (nums[nums.length-1]<target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                dummy = i;
                break;
            }
        }
        return dummy;
    }
}
```
