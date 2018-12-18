# Merge Intervals
本题参考了leetcode结尾的[Solution](https://leetcode.com/problems/merge-intervals/solution/)
## 示例代码
``` java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval x : intervals) {
            if (merged.isEmpty() || merged.getLast().end < x.start) {
                merged.add(x);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, x.end);
            }
        }
        return merged;
    }
}
```
