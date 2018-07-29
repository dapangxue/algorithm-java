# Plus One
## 示例代码
``` java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
```
