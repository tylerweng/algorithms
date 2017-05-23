var countHelper = function(s) {
    let str = "";
    let count = 1;
    let curr = s[0];
    for (let i = 1; i < s.length; i++) {
        if (curr === s[i]) {
            count++;
        } else {
            str += String(count) + curr;
            count = 1;
            curr = s[i];
        }
    }
    str += String(count) + curr;
    return str;
};

var countAndSay = function(n) {
    if (n === 1) return "1";
    return countHelper(countAndSay(n - 1));
};
