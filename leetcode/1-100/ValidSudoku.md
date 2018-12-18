# Valid Sudoku
## 示例代码
``` java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length, column = board[0].length;
        boolean[][] rowVerify = new boolean[row][column];
        boolean[][] columnVerify = new boolean[row][column];
        boolean[][] subBoard = new boolean[row][column];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int c = board[i][j] - '1';

                    if (rowVerify[i][c] || columnVerify[c][j] || subBoard[3*(i/3)+j/3][c]) {
                        return false;
                    }
                    rowVerify[i][c] = columnVerify[c][j] = subBoard[3*(i/3)+j/3][c] = true;
                }
            }
        }

        return true;
    }
}
```
