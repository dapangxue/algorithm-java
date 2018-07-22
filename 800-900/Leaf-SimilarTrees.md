# Leaf-Similar Trees
## 示例代码
``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeafList(root1);
        List<Integer> list2 = getLeafList(root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i =0; i <list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> getLeafList(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        list = getLeafList(root.left);
        List<Integer> right=getLeafList(root.right);
        for (int x:right) list.add(x);
        return list;
    }
}
```
