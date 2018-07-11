# Transpose Matrix
### 示例代码
``` java
class Solution {
    public int[][] transpose(int[][] A) {
        int[][] transposedMatrix = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transposedMatrix[j][i] = A[i][j];
            }
        }
        return transposedMatrix;
    }
}
```
