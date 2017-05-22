// Design an algorithm and write code to remove the duplicate characters
// in a string without using any additional bu er. NOTE: One or two
// additional variables are  ne. An extra copy of the array is not.
// FOLLOW UP
// Write the test cases for this method.

const remDups = str => {
  const res = "";
  const chars = new Set();
  for (let i = 0; i < str.length; i++) {
    if (!chars.has(str[i])) res += str[i];
    chars.add(str[i]);
  }
  return res;
};
