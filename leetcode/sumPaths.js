function sumPaths(grid, i=0, j=0) {
    const m = grid.length;
    const n = grid[0].length;
    if (i === m - 1 && j === n - 1) return 1;
    let right;
    if (grid[i] && grid[i][j + 1]) right = grid[i][j + 1];
    let below;
    if (grid[i + 1] && grid[i + 1][j]) below = grid[i + 1][j];
    if (right === 1 && below === 1) {
        return sumPaths(grid, i+1, j) + sumPaths(grid, i, j+1);
    } else if (right === 1) {
        return sumPaths(grid, i, j+1);
    } else if (below === 1) {
        return sumPaths(grid, i+1, j);
    } else {
      return 0;
    }
}

let grid = [
    [1, 1],
    [1, 1],
    [1, 1]
];

sumPaths(grid); // 3
