const longestCommonPrefix = strs => {
    if (strs.length === 0) return "";
    let pre = strs[0];
    for (let i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(pre) !== 0) {
            pre = pre.slice(0, pre.length - 1);
        }

    }
    return pre;
};

let strs = [
    "abcd",
    "abcez",
    "ab"
];

longestCommonPrefix(strs); // ab
