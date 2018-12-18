# 计算最大容积
---
## 思路
1. 从数组两边开始求组成的容器的容积，不断和新的容器的容积比较，保存较大的容积
2. 容器的两边哪边比较小，哪边就向里移动，可以理解为保存下长边的优势，短边不断向里面移动。

## 示例代码
``` java
class Solution {
    public int maxArea(int[] height) {
        // 1.标记的数组的左右两端
        int left = 0, right = height.length-1;
        int maxVolume = 0;
        while (left < right) {
            // 2.遍历计算容积
            maxVolume = Math.max(maxVolume, Math.min(height[left], height[right])*(right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVolume;
    }
}
```
