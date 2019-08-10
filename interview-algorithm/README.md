# 排序数组中和为某个固定值的二元组和三元组

## 思路

双指针，通常双指针的解法就是数组的左右两侧分配left和right,按照既定的条件进行移动。

## 示例代码

### 求二元组

``` JAVA
import java.util.Scanner;
import java.util.concurrent.locks.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int left = 0, right = n - 1;
        /*
        核心思路
        */
        while (left < right) {
            int sum = array[left] + array[right];

            if (sum == k) {
                System.out.println(array[left] + "," + array[right]);
                while (left + 1 < n && array[left + 1] == array[left]) {
                    left++;
                }
                while (right - 1 >= 0 && array[right - 1] == array[right]) {
                    right--;
                }
                left++;
                right--;
            } else if (sum < k) {
                left ++;
            } else {
                right --;
            }
        }
    }

}

```

### 求三元组

``` JAVA
import java.util.Scanner;
import java.util.concurrent.locks.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            helper(i, array, k - array[i]);
        }
    }

    /**
     * 寻找后续子数组中的二元组
     * @param f
     * @param nums
     * @param k
     */
    public static void helper(int f, int[] nums, int k) {
        int left = f + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                System.out.println(nums[f] + " " + nums[left] + " " + nums[right]);
                while (nums[left + 1] == nums[left]) {
                    left++;
                }
                while (nums[right - 1] == nums[right]) {
                    right--;
                }
                left ++;
                right --;

            } else if (sum < k) {
                left ++;
            } else {
                right --;
            }
        }
    }

}
```
