const map = {
    "[" : "]",
    "(" : ")",
    "{" : "}"
};

const validParentheses = str => {
    const stack = [];
    for (let i = 0; i < str.length; i++) {
        const char = str[i];
        if (map[char] !== undefined) {
            stack.push(map[char]);
        } else if (stack.pop() !== char) {
            return false;
        }
    }
    return stack.length === 0;
}
