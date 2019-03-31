# 判断一棵树是否是二叉搜索树
## 示例代码
``` java
package basic.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/30 0030
 */
public class Tree {

    /**
     * 二叉树数据结构
     */
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 将数组构建为一个二叉树
     * // TODO: 2019/3/30 0030 测试此函数是否可用
     * @param array
     * @return
     */
    public TreeNode createBinaryTree(int[] array) {
        if (array.length == 1) {
            return new TreeNode(array[0]);
        }

        List<TreeNode> list = new ArrayList<>();
        // 首先构造树节点
        for (int i = 0, length = array.length; i < length; i++) {
            list.add(new TreeNode(array[i]));
        }
        // 构造二叉树时每个结点编号
        int count = 0;
        while (count <= (list.size() - 2) / 2) {
            int a = 0, b = 0;
            // 边界判断
            if ((a = count * 2 + 1) <= list.size() - 1) {
                list.get(count).left = list.get(a);
            }
            if ((b = count * 2 + 2) <= list.size() - 1) {
                list.get(count).right = list.get(b);
            }
            count ++;
        }
        return list.get(0);
    }

    /**
     * 中序遍历
     * @param node 输入链表头结点
     */
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    /**
     * 判断二叉树是不是二叉搜索树
     * @param node 头结点
     * @return 是否是二叉搜索树
     */
    public boolean isValidBinarySearchTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        return isValidBinarySearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 判断二叉树是不是二叉搜索树
     * @param node 头结点
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    private boolean isValidBinarySearchTree(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value <= min || node.value >= max) {
            return false;
        }
        return isValidBinarySearchTree(node.left, min, node.value) &&
                isValidBinarySearchTree(node.right, node.value, max);
    }

    /**
     * input in-order array,determine if it is a valid BinarySearchTree
     * @param array inOrder array
     * @return true/false
     */
    private boolean isValidBinarySearchTree(int[] array) {
        for (int i = 0; i <= (array.length - 2) / 2; i++) {
            if (array[i] <= array[i * 2 + 1] || array[i] >= array[i * 2 + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] array = new int[]{10, 5, 15, 3, 7, 18, 13};
        TreeNode t = tree.createBinaryTree(array);
        tree.inOrder(t);
        System.out.println(tree.isValidBinarySearchTree(t));
        System.out.println(tree.isValidBinarySearchTree(array));
    }
}

```
