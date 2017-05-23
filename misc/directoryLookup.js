const directoryLookup = (directory, path, defValue) => {
  const subPaths = path.split(".");
  const nextPath = subPaths[0];
  if (directory[nextPath] === undefined) return defValue;
  if (subPaths.length === 1) return directory[nextPath];
  return directoryLookup(directory[nextPath], subPaths.slice(1).join("."), defValue);
};
