# Search a 2D Matrix
`数组查找`
## 示例代码
``` java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){
            int curr = matrix[row][col];

            if(target == curr){
                return true;
            }else if(target > curr){
                row = row + 1;
            }else{
                col = col - 1;
            }
        }

        return false;
    }
}
```
``` java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = m-1; i >= 0 ; i--) {
            if (target <= matrix[i][n-1]) {
                for (int j = n-1; j >= 0; j--) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            } else {
                break;
            }
        }
        return false;
    }
}
```
