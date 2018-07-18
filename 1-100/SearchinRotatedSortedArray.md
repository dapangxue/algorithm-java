# Search in Rotated Sorted Array
## 示例代码
``` java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // 右边升序
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
```
