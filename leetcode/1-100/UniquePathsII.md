# Unique Paths II
## 思路
本题和62题[Unique Paths](https://github.com/iswuxue/leetcode-java/blob/master/1-100/UniquePaths.md)一样，只不过只要碰到障碍，就将后面的虚拟数组置0
## 示例代码
``` java
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dummy = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dummy[row][col] = 0;
                } else if (row == 0 && col == 0) {
                    dummy[row][col] = 1;
                } else if (row == 0 && col > 0) {
                    dummy[row][col] = dummy[row][col-1];
                } else if (row > 0 && col == 0) {
                    dummy[row][col] = dummy[row-1][col];
                } else {
                    dummy[row][col] = dummy[row-1][col] + dummy[row][col-1];
                }
            }
        }
        return dummy[m-1][n-1];
    }
}
```
