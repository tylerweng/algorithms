const knapsack = (values, weights, capacity) => {
  const n = values.length;
  let bestMax = 0;
  const matrix = [];
  for (let i = 0; i < n; i++) {
    const row = new Array(capacity + 1);
    row.fill(0);
    matrix[i] = row;
  }
  for (let x = 1; x < n; x++) {
    for (let y = 0; y <= capacity; y++) {
      if (weights[x - 1] > y) {
        matrix[x][y] = matrix[x - 1][y];
      } else {
        const currMax = Math.max(
          matrix[x - 1][y],
          matrix[x - 1][y - weights[x - 1]] + values[x - 1]
        );
        matrix[x][y] = currMax;
        if (currMax > bestMax) bestMax = currMax;
      }
    }
  }

  return bestMax;
};

module.exports = knapsack;
