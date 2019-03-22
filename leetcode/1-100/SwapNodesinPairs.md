# Swap Nodes in Pairs
## 思路
本题是一道基础的链表操作题
## 示例代码
### 方法一
``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        temp.next = head;

        while (temp.next != null && temp.next.next != null) {
            ListNode t = temp.next.next;
            temp.next.next = t.next;
            t.next = temp.next;
            temp.next = t;
            temp = temp.next.next;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        // 简历一个虚拟结点，用来返回答案
        ListNode dummy = new ListNode(-1);
        // tail为修改的最后一个结点
        ListNode tail = dummy;
        tail.next = head;
        // 当结点为偶数的时候，定义两个结点，相互交换
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1 != null && node2 != null) {
            tail.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 以下三步，node2和node1结点互换
            ListNode temp = node1;
            node1 = node2;
            node2 = temp;
            tail = node2;
            node1 = node1.next.next;
            if (node2.next != null)
                node2 = node2.next.next;
        }
        return dummy.next;
    }
}
```
### 方法二
采用递归的思想
``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode t = head.next;
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;
    }
}
```
