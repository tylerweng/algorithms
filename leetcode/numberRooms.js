var _ = require('underscore');

function sayHello() {
  console.log('Hello, World');
}

_.times(5, sayHello);


/*
Your previous Plain Text content is preserved below:

/*
Given a list of meetings in an office for a given day, write a function that determines the minimum number of rooms required to avoid room conflicts.

 Example 1:
     # Input
     monday = [
         [ 8, 9 ], # morning call
         [ 11, 12 ], # daily stand-up
         [ 14, 15 ], # design review
     ]

     # Output
     min_rooms_needed = 1

 Example 2:
     # Input
     tuesday = [
         [  8, 12 ], # morning investor meeting
         [ 10, 11 ], # JIRA bug triage
         [ 11, 12 ], # daily stand-up
         [ 15, 16 ], # marketing review
     ]

     # Output
     min_rooms_needed = 2

     f(meetings) -> min_rooms_needed

  Example 3:
         [ 0, 24 ],
         [ 4, 24 ],
         [ 1, 2 ],
         [ 2, 3 ],
         [ 3, 4 ],
         [ 4, 5 ],
         [ 5, 6 ],
         [ 6, 7 ],
         [ 7, 8 ],
         [ 8, 9 ],
         [ 9, 10 ],
         [ 10, 11 ],
         [ 11, 12 ],
         [ 12, 13 ],
         [ 13, 14 ],
         [ 14, 15 ],
         [ 15, 16 ],
         [ 16, 17 ],
         [ 17, 18 ],
         [ 18, 19 ],
         [ 19, 20 ],
         [ 20, 21 ],
         [ 21, 22 ],
         [ 23, 23 ],
         [ 23, 24 ],
*/


// find the max number of Overlaps for any given room

function overlaps(m1, m2) {
  let s1 = m1[0], e1 = m1[1], s2 = m2[0], e2 = m2[1];
  return (
    (s1 >= s2 && s1 < e2) ||
    (s2 >= s1 && s2 < e1)
  );
}

function numRooms(meetings) {
  let map = {};
  for (let i = 0; i < meetings.length; i++) {
    map[i] = []; // init at 1 because i am just going to return the maxValue, here a event overlaps with self
  }

  let maxOverlapKey = 0;
  let numOverlaps = 0;
  for (let i = 0; i < meetings.length - 1; i++) {
    for (let j = i + 1; j < meetings.length; j++) {
      let m1 = meetings[i];
      let m2 = meetings[j];
      if (overlaps(m1, m2)) {
        map[i].push(j);
        map[j].push(i);
        numOverlaps = Math.max(numOverlaps, map[i].length, map[j].length);
        if (numOverlaps === map[i]) maxOverlapsKey = i;
        if (numOverlaps === map[j]) maxOverlapsKey = j;
      }
    }
  }

  // use maxOverlapsKey to find the number of overlaps in all the rooms, return that ++min);
  let minOverlaps = Math.min(
    numOverlaps,
    Math.min(...map[maxOverlapKey].map(i => map[i].length))
  );
  return ++minOverlaps;
}

let shouldBe1 = [
  [8, 9],
  [11, 12],
  [14, 15]
];

let shouldBe2 = [
  [8, 12],
  [10, 11],
  [11, 12],
  [15, 16]
];

let shouldBe2a = [
  [9, 10],
  [9, 10]
];

let ex3 = [
  [ 0, 24 ],
         [ 4, 24 ],
         [ 1, 2 ],
         [ 2, 3 ],
         [ 3, 4 ],
         [ 4, 5 ],
         [ 5, 6 ],
         [ 6, 7 ],
         [ 7, 8 ],
         [ 8, 9 ],
         [ 9, 10 ],
         [ 10, 11 ],
         [ 11, 12 ],
         [ 12, 13 ],
         [ 13, 14 ],
         [ 14, 15 ],
         [ 15, 16 ],
         [ 16, 17 ],
         [ 17, 18 ],
         [ 18, 19 ],
         [ 19, 20 ],
         [ 20, 21 ],
         [ 21, 22 ],
         [ 23, 23 ],
         [ 23, 24 ],
  ];

console.log(numRooms(shouldBe1) === 1); // 1
console.log(numRooms(shouldBe2) === 2);
console.log(numRooms(shouldBe2a) === 2);
console.log(numRooms(ex3));
