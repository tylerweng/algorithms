process.stdin.resume();
process.stdin.setEncoding("ascii");
var input = "";
process.stdin.on("data", function (chunk) {
input += chunk;
});
process.stdin.on("end", function () {
// now we can read/parse input
    let arr = input.split("\n");
    let n = parseInt(arr[0], 10);
    let missing = [];
    let prices = new Array(n);
    for (let i = 1; i < arr.length; i++) {
        let row = arr[i];
        let price = row.split("\t")[1];
        if (price.includes("Missing")) {
            missing.push(i);
        } else {
            prices[i] = parseFloat(price);
        }
    }
    console.log("prices.includes(undefined)", prices.includes(undefined));
    console.log("missing", missing);
    console.log("prices", prices);
    while(prices.includes(undefined)) {
        for (let i = 0; i < missing.length; i++) {
            let j = missing[i];
            if (prices[j] !== undefined) continue;
            let start = (j - 1 >= 0 ? j - 1 : 0);
            while (prices[start] === undefined) {
                start--;
            }
            let stop = (j + 1) % n;
            while(prices[stop] === undefined) {
                stop++;
            }
            if (start > stop) start -= n;
            let startVal = prices[start];
            let stopVal = prices[stop];
            let diff = Math.abs((stopVal - startVal) / (stop - start));
            for (let k = start + 1; k < stop; k++) {
                prices[k] = startVal + diff * Math.abs(k - start);
            }
        }
    }
    missing.forEach(i => console.log(prices[i]));
});
