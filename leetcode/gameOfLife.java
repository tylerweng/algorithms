class Solution {
    int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int numNeighbors(int[][]board, int i, int j, int m, int n) {
        int count = 0;
        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) ++count;
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] clone = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = numNeighbors(board, i, j, m, n);
                if (count < 2 && board[i][j] == 1) {
                    clone[i][j] = 0;
                } else if (count < 4 && board[i][j] == 1) {
                    clone[i][j] = 1;
                } else if (board[i][j] == 1) {
                    clone[i][j] = 0;
                } else if (count == 3 && board[i][j] == 0) {
                    clone[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = clone[i][j];
            }
        }
    }
}