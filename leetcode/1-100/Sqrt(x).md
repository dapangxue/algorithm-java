# Sqrt(x)
求平方根
## 示例代码
投机取巧的办法
``` java
class Solution {
    public int mySqrt(int x) {
       return (int) Math.sqrt(x);
    }
}
```
``` java
class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (long)(low+high)/2;
            long a = mid * mid;
            if (a == x) {
                return (int)mid;
            } else if (a < x) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return high;
    }
}
```
