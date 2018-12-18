# Unique Paths
## 思路
设定一个虚拟数组用来表示到达当前位置所用的方法，`dummy[row][col] = 8`表示到达这个位置共有8种方法。

其实每个位置如果靠在边界都只有一种方法，比如`dummy[0][4] = 1`,它只能从`dummy[0][3]`过来
## 示例代码
``` java
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dummy = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                 if (row == 0 && col == 0) {
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
