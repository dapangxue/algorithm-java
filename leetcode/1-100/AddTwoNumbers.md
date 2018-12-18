# Add Two Numbers
## 思路
本题目是一道链表题，需要将每两个对应结点的`val`相加起来，超过10就进位，加到下一次对应结点的和上，循环中每次计算的和都要清零。
## 示例代码
``` java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int sum = 0, carry = 0;
       ListNode head = new ListNode(-1);
       ListNode dummy = head;
       while (l1 != null || l2 != null || carry != 0) {
           sum = 0;
           if (l1 != null) {
               sum += l1.val;
               l1 = l1.next;
           }
           if (l2 != null) {
               sum += l1.val;
               l2 = l2.next;
           }
           sum = sum + carry;
           carry = sum/10;
           ListNode temp = new ListNode(sum%10);
           dummy.next = temp;
           dummy = dummy.next;
       }
       return head.next;
    }
}
```
