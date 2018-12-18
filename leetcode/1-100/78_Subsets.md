# Subsets
## 示例代码
方法一
``` java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> fix = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fix.add(list);
        for (int i = 0; i < nums.length; i++) {
            int size = fix.size();
            for (int j = 0; j < size; j++) {
                fix.add(new ArrayList<>(fix.get(j)));
                fix.get(j).add(nums[i]);
            }
        }
        return fix;
    }
}
```
方法二
``` java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> fix = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, list, fix);
        return fix;
    }
    private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> fix) {
        fix.add(new ArrayList(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i+1, list, fix);
            list.remove(list.size()-1);
        }
    }
}
```
