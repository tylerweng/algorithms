const quickSort = arr => {
  if (arr.length < 2) return arr;

  const left = [];
  const right = [];
  const pivot = arr[0];
  for (let i = 1; i < arr.length; i++) {
    arr[i] < pivot
      ? left.push(arr[i])
      : right.push(arr[i]);
  }

  return quickSort(left)
           .concat(pivot)
           .concat(quickSort(right));
};

module.exports = quickSort;
