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
``` java
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
```
``` JAVA
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
```
