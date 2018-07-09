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
