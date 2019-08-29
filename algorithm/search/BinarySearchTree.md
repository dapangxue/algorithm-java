# 二叉搜索树

## 示例代码

``` JAVA
package company.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-8-29
 */
public class BinarySearchTree {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode root = null;

    public static void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
        } else {
            TreeNode parent = root;
            TreeNode current = root;

            while (true) {
                parent = current;
                if (current.value == node.value) {
                    return;
                }
                if (current.value > node.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (current.value < node.value) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public static TreeNode find(int value) {
        TreeNode current = root;

        while (current != null && current.value != value) {
            if (current.value < value) {
                current = current.right;
            } else if (current.value > value) {
                current = current.left;
            }

            if (current == null) {
                throw new NullPointerException("查找结点为空");
            }
        }
        return current;
    }

    /**
     * 先序遍历
     * @return
     */
    public static List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                result.add(t.value);
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }
            }
        }
        return result;
    }

    /**
     * 中序遍历
     * @return
     */
    public static List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    result.add(root.value);
                    root = root.right;
                }
            }
        }
        return result;
    }

    public static List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(root);
            while (!stack1.isEmpty()) {
                TreeNode t = stack1.pop();
                stack2.push(t);
                if (t.left != null) {
                    stack1.push(t.left);
                }
                if (t.right != null) {
                    stack1.push(t.right);
                }
            }

            while (!stack2.isEmpty()) {
                result.add(stack2.pop().value);
            }
        }
        return result;
    }

    public static List<Integer> show(int i) {
        switch (i) {
            case 0 : {
                return preOrder();
            }
            case 1 : {
                return inOrder();
            }
            case 2 : {
                return postOrder();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        insert(8);
        insert(4);
        insert(2);
        insert(12);
        insert(14);
        System.out.println(find(4).value);
        System.out.println(show(2));
    }
}

```

## 参考文献

[二叉搜索树详解（Java实现）](https://www.cnblogs.com/yahuian/p/10813614.html)
