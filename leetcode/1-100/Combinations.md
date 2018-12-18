# Combinations
```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

```
## 示例代码
``` java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> fix = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        addElement(list, fix, n, k,1);
        return fix;
    }

    public void addElement(List<Integer> list, List<List<Integer>> fix, int n, int k, int index) {
        if (list.size() == k) {
            fix.add(new ArrayList(list));
            return;
        }
        for (int m = index; m <= n; m++) {
            list.add(m);
            addElement(list, fix, n, k, m+1);
            list.remove(list.size() - 1);
        }
    }
}
```
