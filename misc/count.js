let n = 1;
console.log(n);
n++;

const count = setInterval(function() {
  console.log(n);
  n++;
  if (n === 6) stopCount();
}, 1000);

const stopCount = () => {
  clearInterval(count);
};

count;
