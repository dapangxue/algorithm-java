# GetMaxLength
未排序正数数组中累加和为给定值的最长子数组长度
## 示例代码
``` java
public class GetMaxLength {
    public int getMaxLength(int[] array, int k) {
        int left = 0, right = 0;
        int len = 1, sum = array[0];

        while (right < array.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= array[left++];
            } else if (sum < k) {
                right++;
                if (right >= array.length) {
                    break;
                }
                sum += array[right];
            } else {
                sum -= array[left++];
            }
        }
        return len;
    }
}
```
