# Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            if (root.left != null) {
                list.addAll(inorderTraversal(root.left));
            }    
            list.add(root.val);
            if (root.right != null) {
                list.addAll(inorderTraversal(root.right));
            }
        }
        return list;
    }
}
```
