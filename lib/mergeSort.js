const merge = (left, right) => {
  const merged = [];

  while (left.length > 0 && right.length > 0) {
    left[0] < right[0]
      ? merged.push(left.shift())
      : merged.push(right.shift());
  }
  
  return merged.concat(left).concat(right);
};

const mergeSort = arr => {
  if (arr.length < 2) return arr;

  const mIdx = Math.floor(arr.length / 2);
  const left = mergeSort(arr.slice(0, mIdx));
  const right = mergeSort(arr.slice(mIdx));

  return merge(left, right);
};

module.exports = mergeSort;
