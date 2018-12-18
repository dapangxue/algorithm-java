# Boats to Save People
## 示例代码
``` java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int length = people.length;
        int left = 0;
        int time = 0;
        
        for (int i = length-1; i >= left; i--) {
            if (i > left && people[left] + people[i] <= limit) {
                left++;
            }
            time++;
        }
        return time;
    }
}
```