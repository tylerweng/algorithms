const permute = arr => {
    if (arr.length === 0) return [[]];
    let perms = [];
    let first = arr[0];
    let withoutFirst = permute(arr.slice(1));
    withoutFirst.forEach(perm => {
       for (let i = 0; i <= perm.length; i++) {
           perms.push(perm.slice(0, i).concat(first).concat(perm.slice(i)));
       }
    });
    return perms;
};

const derangements = (arr, map) => {
    if (arr.length  === 0) return [[]];
    let res = [];
    let first = arr[0];
    let withoutFirst = derangements(arr.slice(1), map);
    withoutFirst.forEach(der => {
        for (let i = 0; i <= der.length; i++) {
            let newDer = der.slice(0, i).concat(first).concat(der.slice(i));
            if (validIndices(newDer, map)) res.push(newDer);
        }
    });
    return res;
};

const createIndices = arr => {
    const map = {};
    for (let i = 0; i < arr.length; i++) {
        if (!map.hasOwnProperty(arr[i])) map[arr[i]] = new Set();
        map[arr[i]].add(i);
    }
    return map;
};

const validIndices = (arr, map) => {
    for (let i = 0; i < arr.length; i++) {
        if (map[arr[i]].has(i)) return false;
    }
    return true;
};
