const map = {
  "[" : "]",
  "(" : ")",
  "{" : "}"
};

const validParentheses = str => {
  const stack = [];
  for (let i = 0; i < str.length; i++) {
    const char = str[i];
    if (map[stack[stack.length - 1]] === char) {
      stack.pop();
    } else {
      stack.push(char);
    }
  }
  return stack.length === 0;
};
