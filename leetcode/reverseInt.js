/**
 * @param {number} x
 * @return {number}
 */
var reverseInt = function(x) {
    let isNeg = false;
    if (x < 0) {
        isNeg = true;
        x *= -1;
    }
    let reversed = 0;
    while (x > 0) {
        let tail = x % 10;
        reversed = reversed * 10 + tail;
        x = Math.floor(x / 10);
    }
    return isNeg ? -reversed : reversed;
};
