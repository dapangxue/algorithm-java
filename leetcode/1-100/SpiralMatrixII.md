# Spiral Matrix II
## 示例代码
``` java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int circle = n/2;
        int row = 0, col = 0, val = 1, p = n;

        for (int i = 0; i < circle; i++) {
            for (col = i; col < n - i; col++) {
                result[i][col] = val++;
            }
            for (row = i+1; row < n - i; row++) {
                result[row][n-i-1] = val++;
            }
            for (col = n-i-2; col >= i; col--) {
                result[n-i-1][col] = val++;
            }
            for (row = n-i-2; row >i; row--) {
                result[row][i] = val++;
            }
        }
        if (n%2 != 0) result[circle][circle] = val++;
        return result;
    }
}
```
