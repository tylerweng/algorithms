function main() {
    var T = parseInt(readLine());
    for(var a0 = 0; a0 < T; a0++){
        var n = parseInt(readLine());
        q = readLine().split(' ');
        q = q.map(Number);
        // your code goes here
        let tooChaotic = false;
        for (let i = 0; i < n; i++) {
            if (q[i] - i - 1 > 2) {
                console.log("Too chaotic");
                tooChaotic = true;
                break;
            }
        }
        if (tooChaotic) continue;
        let nSwaps = 0;
        for (let j = 0; j < n; j++) {
            let swapped = false;
            for (let k = 0; k < n - 1; k++) {
                if (q[k] > q[k + 1]) {
                    const temp = q[k];
                    q[k] = q[k + 1];
                    q[k + 1] = temp;
                    swapped = true;
                    nSwaps++;
                }
            }
            if (!swapped) break;

        }
        console.log(nSwaps);
    }
}
