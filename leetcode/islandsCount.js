const ADJACENT_DELTAS = [
    [1, 0], [-1, 0], [0, 1], [0, -1]
];

const validAndUnseen = (pos, posStr, m, n, unseen) => {
    return (
        (pos[0] >= 0 && pos[0] < m) &&
        (pos[1] >= 0 && pos[1] < n) &&
        (grid[pos[0]][pos[1]] === 1) &&
        (unseen.has(posStr))
    );
};

const stringifyPos = pos => (String(pos[0]) + "-" + String(pos[1]));

const islandsCount = grid => {
    const unseen = new Set();
    const explored = new Set();
    const m = grid.length;
    const n = grid[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let pos = [i, j];
            let posStr = stringifyPos(pos);
            unseen.add(posStr);
        }
    }
    let count = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let pos = [i, j];
            count = bfs(pos, m, n, grid, explored, unseen, count);
        }
    }
    return count;
};

const bfs = (pos, m, n, grid, explored, unseen, count) => {
    const queue = [pos];
    let increment = false;
    while (queue.length > 0) {
        pos = queue.shift();
        let posStr = stringifyPos(pos);
        if (explored.has(posStr)) continue;
        explored.add(posStr);
        if (grid[pos[0]][pos[1]] === 0) continue;
        increment = true;
        ADJACENT_DELTAS.forEach(delta => {
            let newPos = [pos[0] + delta[0], pos[1] + delta[1]];
            let newPosStr = stringifyPos(newPos);
            if (validAndUnseen(newPos, newPosStr, m, n, unseen)) {
                queue.push(newPos);
                unseen.delete(newPosStr);
            }
        });
    }
    return increment ? ++count: count;
}

let grid = [
    [1, 1, 0],
    [1, 0, 1],
    [0, 1, 0],
    [1, 1, 1],
    [0, 0, 0]
];

islandsCount(grid); // 3
