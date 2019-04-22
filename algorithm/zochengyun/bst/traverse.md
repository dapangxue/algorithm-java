# 二叉树的递归和非递归前序、中序、后序遍历
## 示例代码
``` java
package zuo.bst;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * 二叉树的递归和非递归前序遍历、中序遍历、后序遍历
 * @author WuXue
 * @date 2019/4/22 0022
 */
public class BinarySearchTreeTraverse {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void preOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public static void inOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left);
        System.out.println(root.value);
        inOrderRecursion(root.right);
    }

    public static void posOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrderRecursion(root.left);
        posOrderRecursion(root.right);
        System.out.println(root.value);
    }

    /**
     * 非递归实现前序遍历
     * @param root
     */
    public static void preOrderNonRecursion(TreeNode root) {
        System.out.print("preOrderRecursion : ");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                System.out.print(stack.peek().value);
                TreeNode temp = stack.pop();
                if (temp.left != null) {
                    stack.push(temp.right);
                }
                if (temp.right != null) {
                    stack.push(temp.left);
                }
            }
        }
    }

    public static void inOrderNonRecursion(TreeNode root) {
        System.out.println("in-order : ");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.value);
                    root = root.right;
                }
            }
        }
    }

    public static void posOrderNonRecursion(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                TreeNode temp = stack1.pop();
                if (temp.left != null) {
                    stack1.push(temp.left);
                }
                if (temp.right != null) {
                    stack1.push(temp.right);
                }
                stack2.push(temp);
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        posOrderNonRecursion(root);
    }
}

```
