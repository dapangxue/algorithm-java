# Word Search
`二维数组中查找单词`、`递归`

这个题目很有意思，先要找到对应`word`的每个字符，再在该字符的上下左右四个方位寻找，并通过另一个数组来标记该元素以前有没有被找到过。
## 示例代码
``` java
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, visit, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visit, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visit[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visit[i][j] = true;
        boolean result = search(board, visit, i-1, j, index+1, word) || search(board, visit, i+1, j, index + 1, word)
            || search(board, visit, i, j+1, index+1, word) || search(board, visit, i, j-1, index+1, word);
        visit[i][j] = false;
        return result;
    }
}
```
