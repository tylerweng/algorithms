/**
 * @param {character[][]} grid
 * @return {number}
 */

var helper = (grid, r, c) => {
  // return 0 immediately if already traversed, out of bounds or water 
  if (r <  0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] !== '1') {
      return;
  } else {
      // mark as traversed
      grid[r][c] = '0'
      helper(grid, r-1, c)
      helper(grid, r+1, c)
      helper(grid, r, c-1)
      helper(grid, r, c+1)
  }
};
var numIslands = function(grid) {
  let count = 0
  for (let r = 0; r < grid.length; r++) {
      for (let c = 0; c < grid[0].length; c++) {
          if (grid[r][c] === '1') {
              helper(grid, r, c)
              count++
          }
      }
  }
  return count;
};