# Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        double count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (head != null) {
            count++;
            head = head.next;
        }
        head = dummy.next;
        System.out.println(count);

        int middle = (int)Math.round(count/2);
        if (count % 2 == 0) {
            middle++;
        }
        count = 1;
        while (count < middle) {
            count++;
            head = head.next;
        }
        return head;
    }
}
```
