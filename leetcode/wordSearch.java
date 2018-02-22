class Solution {
    static boolean[][] visited;

    public boolean helper(char[][] board, String word, int i, int j, int wIdx) {
        if (wIdx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(wIdx) || visited[i][j]) return false;
        visited[i][j] = true;
        boolean madeWord = helper(board, word, i-1, j, wIdx+1)
                || helper(board, word, i+1, j, wIdx+1)
                || helper(board, word, i, j-1, wIdx+1)
                || helper(board, word, i, j+1, wIdx+1);
        visited[i][j] = false;
        return madeWord;
    }
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == word.charAt(0)) {
                    if (helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}