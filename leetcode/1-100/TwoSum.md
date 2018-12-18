# 两数之和
## 示例代码
```java
class Solution{
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            map.put(diff, i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(nums[j]) && map.get(nums[j]) != j) {
                return new int[]{map.get(nums[j]), j};
            }
        }
        
        return null;
    }
}
```
