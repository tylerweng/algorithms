const patternMatch = (pattern, str, i=0, j=0) => {
    console.log("pattern.slice(i)", pattern.slice(i));
    console.log("str.slice(j)", str.slice(j));
    if (i === pattern.length && j === str.length) return true;
    if (i === pattern.length || j === str.length) return false;
    // collapse multiple * and match it against str
    if (pattern[i] === "*") {
        while (pattern[i] === "*") i++;
        while (pattern[i] !== str[j]) j++;
    }
    if (i === pattern.length) return true;
    return (
        pattern[i] === str[j]
            ? patternMatch(pattern, str, i+1, j+1)
            : patternMatch(pattern, str, i, j+1)
    );
};

// Test Cases
console.log(patternMatch("*", "axyzbc") === true);
console.log(patternMatch("a*b*c", "axyzbc") === true);
console.log(patternMatch("a*b*c", "axyzbcz") === false);
console.log(patternMatch("a**z", "azz") === true);
