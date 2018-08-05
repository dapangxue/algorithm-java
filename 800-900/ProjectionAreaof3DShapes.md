# Projection Area of 3D Shapes
## 示例代码
``` java
class Solution {
    public int projectionArea(int[][] grid) {
        int area = 0;
        int m = grid.length, n = grid[0].length;
        // x plane
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    area++;
            }
        }
        
        // x plane
        for (int i = 0; i < m; i++) {
            int xmax = grid[i][0];
            for (int j = 1; j < n; j++) {
                if (grid[i][j] > xmax) {
                    xmax = grid[i][j];
                }
            }
            area += xmax;
        }
        
        // y plane
        for (int i = 0; i < n; i++) {
            int ymax = grid[0][i];
            for (int j = 1; j < m; j++) {
                if (grid[j][i] > ymax) {
                    ymax = grid[j][i];
                }
            }
            area += ymax;
        }
        return area;
    }
}
```