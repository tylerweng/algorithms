function wordpattern(pattern, input, map = {}) {
    if (pattern.length === 0 && input.length === 0) return 1;
    if (pattern.length === 0 || input.length === 0) return 0;
    if (pattern[0] in map) {
        let chars = map[pattern[0]];
        let len = chars.length;
        if (chars === input.slice(0, len)) {
            return wordpattern(pattern.slice(1), input.slice(len), map);
        } else {
            delete map[pattern[0]];
        }
    } else {
        for (let i = 1; i <= input.length - pattern.length; i++) {
            map[pattern[0]] = input.slice(0, i);
            if (wordpattern(pattern.slice(1), input.slice(i), map)) {
              console.log(map)
              return 1;
            }
        }
    }
    console.log(map);
    return 0;
}

function wordpattern(pattern, input, map = {}) {
  if (pattern.length === 0 && input.length === 0) return 1;
  for (let i = 0; i < input.length; i++) {
    let str = input.slice(0, i + 1);
    let cached = map[pattern[0]];
    if (cached) {
      if (cached[1] === pattern.length) map[pattern[0]][0] = str;
      if (str !== cached[0]) continue;
    } else {
      map[pattern[0]] = [str, pattern.length];
    }
    if (wordpattern(pattern.slice(1), input.slice(i + 1), map)) return 1;
  }
  return 0;
}

function wordpattern(pattern, input, map = {}) {
  if (pattern.length === 0 && input.length === 0) return 1;
  for (let i = 0; i < input.length; i++) {
    let str = input.slice(0, i + 1);
    let cached = map[pattern[0]];
    if (cached) {
      if (cached[1] === pattern.length) map[pattern[0]][0] = str;
      if (str !== cached[0]) continue;
    } else {
      map[pattern[0]] = [str, pattern.length];
    }
    if (wordpattern(pattern.slice(1), input.slice(i + 1), map)) {
      let vals = Object.values(map);
      let uniqVals = vals.filter((v, i, a) => a.indexOf(v) === i);
      return vals.length === uniqVals.length;
    }
  }
  return 0;
}



console.log(match('xyzabsxzyabs', 'aabb') === false);
console.log(match('redblueredblue', 'abba') === true);
console.log(match('asdasdasdasd', 'aaaa') === true);
console.log(match('xyzabcxzyabc', 'aabb') === false);
