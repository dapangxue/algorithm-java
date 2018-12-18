# Divide Two Integers
## 思路
1、只要被除数大于等于除数，就从被除数中减去除数，每减去一次结果就增加1。假设最终结果为n，则该算法的时间复杂度为O(n)。

2、只要被除数大于等于除数的2倍，我们就将除数和结果均乘以2，直到被除数小于除数的2倍。接着将被除数更新为被除数与除数的差，将除数恢复为最初的除数，并重复上述操作直到被除数小于除数。此时算法的时间复杂度降为O(logn）。
## 示例代码
``` java
class Solution {
    public int divide(int dividend, int divisor) {
        long result = deal(dividend, divisor);
        return result>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)result;
    }

    public long deal(long dividend, long divisor) {
        boolean isNegative = dividend*divisor < 0? true:false;

        if (dividend < 0) {
            dividend = Math.abs(dividend);
        }
        if (divisor < 0) {
            divisor = Math.abs(divisor);
        }

        if (dividend < divisor) {
            return 0;
        }

        long sum = divisor;
        long count = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            count += count;
        }
        return isNegative?-(count + deal(dividend-sum, divisor)):(count + deal(dividend-sum, divisor));
    }
}
```
