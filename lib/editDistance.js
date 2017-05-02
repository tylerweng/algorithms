const editDistance = (str1, str2) => {
  const matrix = [];
  for (let i = 0; i <= str1.length; i++) {
    const row = new Array(str2.length + 1);
    row[0] = i;
    matrix[i] = row;
  }

  for (let j = 1; j <= str2.length; j++) {
    matrix[0][j] = j;
  }

  for (let i = 1; i <= str1.length; i++) {
    for (let j = 1; j <= str2.length; j++) {
      const cost = str1[i - 1] === str2[j - 1] ? 0 : 1;
      matrix[i][j] = Math.min(
        matrix[i - 1][j] + 1,
        matrix[i][j - 1] + 1,
        matrix[i - 1][j - 1] + cost
      );
    }
  }

  return matrix[str1.length][str2.length];
};

module.exports = editDistance;
