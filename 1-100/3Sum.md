# 三数之和
## 思路
需要先fix数组中的一个数为目标List的一个值，再检查剩余的数组中的数是否满足条件
## 示例代码
```java
class solution {
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
