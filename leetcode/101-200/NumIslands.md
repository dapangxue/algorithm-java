200.岛屿数量
``` java
package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/26 0026
 */
public class NumIslands {
    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public static void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        if (x - 1 >= 0) {
            dfs(grid, x - 1, y);
        }
        if (x + 1 < row) {
            dfs(grid, x + 1, y);
        }
        if (y - 1 >= 0) {
            dfs(grid, x, y - 1);
        }
        if (y + 1 < col) {
            dfs(grid, x, y + 1);
        }
    }

    /*
    version2 bfs的解法
     */
    public static int numIslands1(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    result ++;
                    // 将值为'1'的加到队列
                    queue.offer(col * i + j);
                    while (!queue.isEmpty()) {
                        int t = queue.poll();
                        int x = t / col;
                        int y = t - x * col;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.offer((x - 1) * col + y);
                        }
                        if (x + 1 < row && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.offer((x + 1) * col + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.offer(x * col + (y - 1));
                        }
                        if (y + 1 < col && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.offer(x * col + (y + 1));
                        }
                    }
                }
            }
        }
        return result;
    }

    /*
    采用并查集
     */

    static class UnionFind {

        // father[x] = y表示x的父节点是y
        int[] father = null;

        // 用于统计当前有多少个节点标签为1，最后剩下的，就是独立的岛屿的数量
        int count = 0;

        public UnionFind(char[][] grid) {
            // init 二维转一维，初始化当前节点的父节点就是自己
            father = new int[grid.length * grid[0].length];
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j ++) {
                    father[i * grid[0].length + j] = i * grid[0].length + j;
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
        }

        /**
         * 查找当前节点的父节点
         * @param x
         * @param y
         * @return
         */
        public int find(int x) {
            if (father[x] == x) {
                return father[x];
            }
            return find(father[x]);
        }

        /**
         * 将它们划定到同一个分区
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);

            if (rootx != rooty) {
                father[rooty] = rootx;
                count--;
            }
        }

        public int getCount() {
            return this.count;
        }

    }

    public static int numIslands2(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0) {
            return result;
        }

        int row = grid.length;
        int col = grid[0].length;
        UnionFind u = new UnionFind(grid);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        u.union(i * col + j, (i - 1) * col + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        u.union(i * col + j, (i + 1) * col + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        u.union(i * col + j, i * col + (j - 1));
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        u.union(i * col + j, i * col + (j + 1));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(u.father));
        return u.getCount();
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '1', '1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1'}};
        System.out.println(numIslands2(a));
        System.out.println(Arrays.deepToString(a));
    }
}
```
