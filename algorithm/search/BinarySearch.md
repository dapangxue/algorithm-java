# 二分查找

二分查找/折半查找是一种查找效率较高的查找算法，折半查找要求数组必须有序

## 二分查找指定值的下标

```java
package basic;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/8/25 0025
 */
public class BinarySearch {

    /**
     * version1 二分查找查找指定值
     * @param array
     * @param k
     * @return
     */
    public static int getK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * version2 用二分查找找到小于或者等于k的最大值
     * @param array
     * @param k
     * @return
     */
    public static int uperK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (right + left + 1) / 2;

            if (array[mid] <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 二分查找大于或等于k的最小值
     * @param array
     * @param k
     * @return
     */
    public static int downK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(getK(a, 12));
        System.out.println(uperK(a, 20));
        System.out.println(downK(a, 3));
    }

}
```
