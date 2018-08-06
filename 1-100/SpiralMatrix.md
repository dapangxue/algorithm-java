# Spiral Matrix
## 示例代码
``` java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int circle = m > n? (n+1)/2:(m+1)/2;
        int p = m, q = n;

        for (int i = 0; i < circle; i++, p-=2, q-=2) {
            for (int col = i; col < i+q; col++) {
                list.add(matrix[i][col]);
            }
            for (int row = i+1; row < i+p; row++) {
                list.add(matrix[row][i+q-1]);
            }
            if (p == 1 || q == 1) {
                break;
            }
            for (int col = i+q-2; col >= i; col--) {
                list.add(matrix[i+p-1][col]);
            }
            for (int row = i+p-2; row > i; row--) {
                list.add(matrix[row][i]);
            }
        }
        return list;
    }
}
```
