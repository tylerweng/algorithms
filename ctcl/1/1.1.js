// Implement an algorithm to determine if a string has all unique
// characters. What if you can not use additional data structures?

const allUnique = str => {
  const chars = new Set();
  for (let i = 0; i < str.length; i++) {
    if (chars.has(stri[i])) return false;
    chars.add(str[i]);
  }
  return true;
};

const allUnique2 = str => {
  for (let i = 0; i < str.length - 1; i++) {
    for (let j = i + 1; i < str.length; j++) {
      if (str[i] === str[j]) return false;
    }
  }
  return true;
};
