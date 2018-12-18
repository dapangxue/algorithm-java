# Permutations
特点：全排列
## 示例代码
``` java
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return res;
        }
        exchange(nums, 0);
        return res;
    }

    private void exchange(int[] nums, int index) {
        List<Integer> list = new ArrayList<>();
        if (index == nums.length-1) {
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            exchange(nums, index+1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
