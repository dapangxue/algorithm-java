# Sort Colors
## 思路
区间`0～zero`表示red,`zero~one`表示white,`one~two`表示blue
以one为索引遍历数组，如果nums[one]大于2，就和two交换，如果等于0就和zero交换，并且要将one的位置和zero的位置向后移动。
## 示例代码
### 方法一
``` java
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0, one = 0, two = nums.length-1;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, one, two--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
### 方法二
``` java
class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
            } else if (nums[i] == 1) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }

        int j = 0;
        while (redCount > 0) {
            System.out.println("ok");
            nums[j++] = 0;
            redCount--;
        }
        while (whiteCount > 0) {
            nums[j++] = 1;
            whiteCount--;
        }
        while (blueCount > 0) {
            nums[j++] = 2;
            blueCount--;
        }
    }
}
```
