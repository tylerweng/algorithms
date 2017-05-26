const match = (str, pat, map = {}) => {
  if (str.length === 0 && pat.length === 0) return true;
  if (str.length === 0 || pat.length === 0) return false;
  if (pat[0] in map) {
    let matchingChars = map[pat[0]];
    let len = matchingChars.length;
    if (matchingChars === str.slice(0, len)) {
      return match(str.slice(len), pat.slice(1), map);
    } else {
      delete map[pat[0]];
      return false;
    }
  } else {
    for (let i = 0; i <= str.length - pat.length; i++) {
      map[pat[0]] = str.slice(0, i);
      if (match(str.slice(i), pat.slice(1), map)) return true;
    }
  }
  return false;
};
