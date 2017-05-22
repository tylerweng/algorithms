// Write code to reverse a C-Style String. (C-String means that “abcd”
// is represented as  ve characters, including the null character.)

const revStr = str => {
  if (str.length === 0) return "";
  return revStr(str.slice(1)) + str[0];
};
