const intToDigits = int => {
  if (int === 0) return ([0]);
  const digits = [];
  while (int > 0) {
    digits.push(int % 10);
    int = Math.floor(int / 10);
  }
  return digits.reverse();
};

const square = int => (int * int);

const sum = digits => (digits.reduce((x1, x2) => x1 + x2));

const sumOfSquareOfDigits = int => (
  sum(
    intToDigits(int)
      .map(d => square(d))
  )
);
const coolNumsCache = new Set();
coolNumsCache.add(1);

const isCoolNum = int => {
  if (coolNumsCache.has(int)) return true;
  while(true) {
    int = sumOfSquareOfDigits(int);
    return (int === 4 ? false : isCoolNum(int));
  }
};

let coolNumsSum;
const findCoolNumsSum = () => {
  for (let i = 2; i <= 1000000; i++) {
    if (isCoolNum(i)) coolNumsCache.add(i);
  }
  let sum = 0;
  coolNumsCache.forEach(n => sum += n);
  coolNumsSum = sum;
};

findCoolNumsSum();
// coolNumsSum = 70601040511
console.log(coolNumsSum);
