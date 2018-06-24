# 4Sum
## 思路
本题思路和[三数之和一样](https://github.com/iswuxue/leetcode-java/blob/master/1-100/3Sum.md),先fix两个数，多了一个for循环

## 示例代码
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int fix = 0, target = 0;
        List<List<Integer>> list = new ArrayList();

        for (int i = 0; i < nums.length-2; i++) {
            // fix数组中的第i个数
            fix = -nums[i];
            int head = i+1;
            int tail = nums.length - 1;
            while (head < tail) {
                target = nums[head] + nums[tail];
                if (fix == target) {
                    list.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    int previousHead = head;   
                    while (nums[previousHead] == nums[++head]) {
                        previousHead = head;
                    }
                    tail--;
                } else if (fix < target) {
                    tail--;
                } else {
                    head++;
                }
            }
            int preivousI = i;
            while (i < nums.length && nums[i] == nums[preivousI]) {
                i++;
            }
            i--;
        }
        return list;
    }
}
```
