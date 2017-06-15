class BTNode {
    constructor(data) {
        this.data = data;
        this.left = this.right = null;
    }
}
const traverseRight = node => {
    let queue = [];
    let res = [];
    let level = 0;
    let encounteredLevels = new Set();
    queue.push({level, node});
    while (queue.length > 0) {
      console.log("queue", queue);
        let obj = queue.shift();
        let node = obj.node;
        level = obj.level;
        if (!encounteredLevels.has(level)) {
            encounteredLevels.add(level);
            res.push(node.data);
        }
        if (node.right !== null) queue.push({level: level + 1, node: node.right});
        if (node.left !== null) queue.push({level: level + 1, node: node.left});
    }
    return res;
};

let node = new BTNode(5);
node.right = new BTNode(6);
node.right.right = new BTNode(8);
node.right.left = new BTNode(10);
node.right.left.right = new BTNode(11);
node.left = new BTNode(12);
node.left.left = new BTNode(13);
node.left.left.right = new BTNode(14);
node.left.left.right.right = new BTNode(15);
node.left.left.right.right.left = new BTNode(100);

traverseRight(node) // [5, 6, 8, 11, 15, 100]
