const patternMatch = (str, pattern) => {
    let s = 0, p = 0, match = 0, starIdx = -1;
    while (s < str.length) {
        if (p < pattern.length && str[s] === pattern[p]) {
            ++s;
            ++p;
        } else if (p < pattern.length && pattern[p] === "*") {
            starIdx = p;
            match = s;
            ++p;
        } else if (starIdx !== -1) {
            p = starIdx + 1;
            ++match;
            s = match;
        } else {
            return false;
        }
    }
    while (p < pattern.length && pattern[p] === "*") {
        p++;
    }
    return p === pattern.length;
};

// Test Cases;
console.log(patternMatch("azz", "a**z") === true);
console.log(patternMatch("az", "a**zx") === false);
console.log(patternMatch("aadasdcasdsa", "*") === true);
