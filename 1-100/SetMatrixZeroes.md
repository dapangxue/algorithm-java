# Set Matrix Zeroes
## 思路
```
扫描第一行和第一列，利用rowFlag和colFlag标记第一行和第一列是否有为0的数
遍历除去第一行和第一列剩下的矩阵,如果发现有为0的数，就将其对应的第一行和第一列置为0
遍历除去第一行和第一列剩下的矩阵，如果对应第一行和第一列为0，则将这个点置为0
最后检查第一行和第一列的标志位是否置位，如果置位将相应的行和列清零
```
## 示例代码
``` java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowFlag = 0, colFlag = 0;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                rowFlag = 1;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                colFlag = 1;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (colFlag == 1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
```
