# Reverse Nodes in k-Group
## 思路
做这题首先要知道链表的长度，知道需要将链表分为几段，然后在针对每段进行操作。
## 示例代码
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int size = 0;
        ListNode run = head;
        while (run != null) {
            size++;
            run = run.next;
        }

        int ring = size/k;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode cur = temp;
        dummy.next = head;
        for (int i = 0; i < ring; i++) {
            cur = temp.next;
            for (int j = 1; j < k; j++) {
                ListNode fix = cur.next;
                cur.next = fix.next;
                fix.next = temp.next;
                temp.next = fix;
            }
            temp = cur;
        }
        return dummy.next;
    }
}
```
