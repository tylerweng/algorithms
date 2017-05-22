const directory = {
  "a" : true,
  "b" : {
    "c" : {
      "d" : {
        "e" : true
      },
      "j" : true
    }
  }
};

const filepaths = (directory, currPath = "", paths = new Set()) => {
  Object.keys(directory).forEach(subdir => {
    if (directory[subdir] === true) {
      paths.add(currPath + subdir);
    } else {
      filepaths(directory[subdir], currPath + subdir + "/", paths);
    }
  });
  return paths;
};


const paths = filepaths(directory);

paths.forEach(el => console.log(el));
