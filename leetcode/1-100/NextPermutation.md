# Next Permutation
## 思路
全排列的字典排序是一个很有意思的算法
1. 首先从右向左找排列的左边小于右边的数。
比如`8， 3， 9， 6, 4, 7, 5, 2, 1`中的4.
2. 从右向左在4~1之间找出刚好大于4的数5，将4和5互换此时序列为`8, 3，9, 6，5, 7, 4, 2, 1`，再将`5`后的数翻转为`8，3，9，6，5，1，2，4，7`

## 示例代码
``` java
class Solution {
    public void nextPermutation(int[] nums) {
        int fixFirst = 0;
        for (int i = nums.length-1; i >= 1; i--) {
            if (nums[i] > nums[i-1]) {
                fixFirst = i-1;
                break;
            }
        }
        int fixSecond = 0;
        for (int j = nums.length-1; j > fixFirst; j--) {
            if (nums[j] > nums[fixFirst]) {
                fixSecond = j;
                break;
            }
        }
        int dummy;
        int[] temp = new int[nums.length - fixFirst -1];
        int count = 0;
        if (fixFirst != fixSecond) {
            dummy = nums[fixFirst];
            nums[fixFirst] = nums[fixSecond];
            nums[fixSecond] = dummy;
            for (int k = nums.length-1; k > fixFirst; k--) {
                temp[count++] = nums[k];
            }
            for (int k = 0; k < temp.length; k++) {
                nums[++fixFirst] = temp[k];
            }
        } else {
            int swap = 0;
            for (int m = 0; m < nums.length/2; m++) {
                swap = nums[m];
                nums[m] = nums[nums.length-m-1];
                nums[nums.length -m -1] = swap;
            }
            System.out.println("hello");
        }
        for (int www : nums) {
            System.out.println(www);
        }
    }
}
```
优化后的算法为：
``` java
class Solution {
    public void nextPermutation(int[] nums) {

        // 1 8 3 6 4 2
        // 1 8 4 2 3 6
        //
        // 1 8 4 2 3 6
        //

        int i = nums.length-1;
        while (i >= 1 && nums[i-1] >= nums[i]) {
            i--;
        }
        i--;
        if (i != -1) {
            int j = nums.length-1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i+1, nums.length-1);
    }

    void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
```
