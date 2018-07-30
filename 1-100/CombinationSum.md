# Combination Sum
## 示例代码
``` java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || target < candidates[0]) {
            return res;
        }
        recursive(candidates, target, 0, new ArrayList(), res);
        return res;
    }

    private void recursive(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(list));
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    return;
                }
                list.add(candidates[i]);
                recursive(candidates, target-candidates[i], i, list, res);
                list.remove(list.size()-1);
            }
        }
    }
}
```
