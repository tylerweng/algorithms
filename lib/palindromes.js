const barrier = s => (
  s.split("").join("|")
);

const expand = (s, i) => {
  let li = i - 1;
  let ri = i + 1;
  let exp = 0;

  while (s[li] === s[ri]) {
    exp++;
    li--;
    ri++;
  }

  return exp;
};

const longestPalindromeSubStr = s => {
  const x = barrier(s);
  const n = x.length;

  let bestExp = 0;
  let expIdx;
  for (let i = 0; i < n; i++) {
    const exp = expand(x, i);
    if (exp > bestExp) {
      bestExp = exp;
      expIdx = i;
    }
  }

  const withBarriers = x.slice(expIdx - bestExp, expIdx + bestExp + 1);

  return withBarriers.split("|").join("");
};
