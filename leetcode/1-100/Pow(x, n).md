# Pow(x, n)
## 示例代码
``` java
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1/power(x, -n);
        } else {
            return power(x, n);
        }
    }

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = power(x, n/2);
        if (n%2 == 0) {
            return temp*temp;
        } else {
            return temp*temp*x;
        }
    }
}
```
