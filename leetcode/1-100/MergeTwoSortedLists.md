# Merge Two Sorted List
## 思路
采用递归的思想
## 示例代码
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
	    return l2;
	}
	if (l2 == null) {
	    return l1;
	}
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
	} else {
            l2.next = mergeTwoLists(l1, l2.next);
	    return l2;
	}
    }
}
```
