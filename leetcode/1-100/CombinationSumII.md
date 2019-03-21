# Combination Sum II
## 示例代码
``` Java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        // 1. 首先将数组排序
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int k, int target, int[] candidates) {
        if (0 == target) {
            // Collections.sort(list);
            result.add(new ArrayList<>(list));
            return;
        }

        if (0 < target) {
            for (int i = k, length = candidates.length; i < length; i++) {
                // 防止出现重复项，在这一次for循环出现过，向下递归也会出现一次，所以只用一次就行
                if (i > k && candidates[i] == candidates[i-1]) continue;
                // 小优化，如果target小于当前candidates[i]，则表示以后的candidates[i ... length - 1]都不会满足条件，因为数组是递增的
                if (candidates[i] > target) {
                    continue;
                }
                list.add(candidates[i]);
                helper(result, list, i + 1, target - candidates[i], candidates);
                list.remove(list.size() - 1);
            }
        }
    }
}
```
