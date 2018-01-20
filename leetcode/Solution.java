class Solution {
    public void helper(char[][] grid, int i, int j, Set<String> seen) {
        String marker = new StringBuilder().append(i).append('-').append(j).toString();
        // check for out of bounds
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] != '1'
                || seen.contains(marker))  {
            return;
        }
        seen.add(marker);
        helper(grid, i-1, j, seen);
        helper(grid, i+1, j, seen);
        helper(grid, i, j-1, seen);
        helper(grid, i, j+1, seen);
    }
    public int numIslands(char[][] grid) {
        Set<String> seen = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String marker = new StringBuilder().append(i).append('-').append(j).toString();
                if (grid[i][j] == '1' && !seen.contains(marker)) {
                    count++;
                    helper(grid, i, j, seen);
                }
            }
        }
        return count;
    }
}