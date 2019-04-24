# 未排序数组中累加和为给定值的最长子数组系列问题
## 示例代码
``` java
package zuo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 未排序数组中累加和为给定值的最长子数组系列问题
 * @author WuXue
 * @date 2019/4/23 0023
 */
public class MaxLength {
    /**
     * 给定一个无序的数组arr,其中元素可正、可负、可0，给定一个整数k，求arr所有的子数组中累加和为k的最长子数组长度
     * @param array
     * @param k
     * @return
     */
     public static int maxLength(int[] array, int k) {
         Map<Integer, Integer> map = new HashMap<>();
         int i = -1, length = 0;
         int sum = 0;
         map.put(sum, i);
         while (i < array.length - 1) {
            sum += array[++i];
            if (sum >= k) {
                if (map.containsKey(sum - k)) {
                    length = Math.max(length, i - map.get(sum - k));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
         }
         return length;
     }

    /**
     * 无序数组arr,其中元素可正、可负、可0。求arr所有的子数组中正数和负数个数相等的最长数组长度
     * @param array
     * @return
     */
     public static int maxLengthPositiveNumberEqualsMinusNumber(int[] array) {
         for (int i = 0, length = array.length; i < length; i++) {
             if (array[i] < 0) {
                 array[i] = -1;
             } else if (array[i] > 0) {
                 array[i] = 1;
             }
         }

         return maxLength(array, 0);
     }

    /**
     * 给定一个arr，其中元素只是1或0.求arr所有的子数组中1和0相等的最长子数组长度
     * @param array
     * @return
     */
     public static int maxLengthOneEqualsZero(int[] array) {
         for (int i = 0, length = array.length; i < length; i++) {
             if (array[i] == 0) {
                 array[i] = -1;
             }
         }
         return maxLength(array, 0);
     }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 3, 3};
        System.out.println(maxLength(array, 12));

        array = new int[]{1, -1, 1, 2, -1, -1};
        System.out.println(maxLengthPositiveNumberEqualsMinusNumber(array));
    }
}

```
