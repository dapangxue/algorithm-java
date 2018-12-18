# Merge k Sorted Lists
## 思路
采用`PriorityQueue`来对k个ListNode进行排序，PriorityQueue的特殊性就在于它保存队列元素的顺序不是按照加入队列的顺序，而是按照队列的大小顺序进行排序，因此在调用poll()方法的时候并不是先取出最先进入队列的元素，而是取出最小的元素。
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
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        // 采用PriorityQueue的定制排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(list.length, new Comparator<ListNode>{
           @Override
           public int compare(ListNode l1, ListNode l2) {
               if (l1.val < l2.val) {
                   return -1;
               } else if (l1.val > l2.val) {
                   return 1;
               } else {
                   return 0;
               }
           }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }
}
```
