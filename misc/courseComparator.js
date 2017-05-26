// Create a function that takes in two arrays of students, and returns
// number of students enrolled in both courses (arr of students)
// A student is defined by firstName, lastName and age, and students
// are unique by the combination of these 3 parameters

const stringifyStudent = student => {
  return (
    "firstName: " + student.firstName,
    "lastName: " + student.lastName,
    "age: " + student.age
  );
};

const doublyEnrolled = (course1, course2) => {
  let students2 = new Set();
  for (let i = 0; i < course2.length; i++) {
    students2.add(stringifyStudent(course2[i]));
  }

  let count = 0;
  for (let j = 0; j < course1.length; j++) {
    if (students2.has(stringifyStudent(course1[j]))) count++;
  }

  return count;
};
