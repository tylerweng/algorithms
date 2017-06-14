const strMult = (s1, s2) => {
    let map = {};
    let tenPwr = 0;
    for (let i = s1.length - 1; i >= 0; i--) {
        for (let j = s2.length - 1; j >= 0; j--) {
            tenPwr = (s1.length - 1 + s2.length - 1) - (i + j);
            let prod = parseInt(s1[i], 10) * parseInt(s2[j], 10);
            let digit = prod % 10;
            let carry = (prod - digit) / 10;
            if (map[tenPwr] === undefined) map[tenPwr] = [];
            map[tenPwr].push(digit);
            if (carry !== 0) {
                if (map[tenPwr + 1] === undefined) map[tenPwr + 1] = [];
                map[tenPwr + 1].push(carry);
                tenPwr++;
            }
        }
    }
    let resStr = "";
    let carry = 0;
    for (let i = 0; i <= tenPwr; i++) {
        let sum = map[i].reduce((x, y) => x + y) + carry;
        let digit = sum % 10;
        carry = (sum - digit) / 10;
        resStr =  String(digit)+ resStr;
    }
    return resStr;
};
