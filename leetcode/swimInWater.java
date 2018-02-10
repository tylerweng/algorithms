class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] max = new int[n][n];
        for (int[] line : max) {
            Arrays.fill(line, Integer.MAX_VALUE);
        }
        dfs(grid, max, 0, 0, grid[0][0]);
        return max[n-1][n-1];
    }
    private void dfs(int[][] grid, int[][] max, int x, int y, int cur) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || Math.max(cur, grid[x][y]) >= max[x][y]) {
            return;
        }
        max[x][y] = Math.max(cur, grid[x][y]);
        dfs(grid, max, x-1, y, max[x][y]);
        dfs(grid, max, x+1, y, max[x][y]);
        dfs(grid, max, x, y-1, max[x][y]);
        dfs(grid, max, x, y+1, max[x][y]);
    }
}