# Binary Tree Inorder Traversal
## 示例代码
### 方法一：递归
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
### 方法二：堆栈
``` java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            // 不断将结点的左子结点压入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root .right;
        }
        return list;
    }
}
```
