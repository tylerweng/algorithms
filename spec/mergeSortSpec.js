describe("mergeSort", function() {
  // shallow comparator of arrays
  const ArrHelper = require("../lib/ArrHelper");
  const mergeSort = require("../lib/mergeSort");
  const comparator = ArrHelper.comparator;

  const arr1 = mergeSort([]);
  const sol1 = [];
  const arr2 = mergeSort([-9]);
  const sol2 = [-9];
  const arr3 = mergeSort([-29, 900, -82, 0, 0, 23, 4]);
  const sol3 = [-82, -29, 0, 0, 4, 23, 900];

  it("handles trivial cases", function() {
    expect(comparator(arr1, sol1)).toBeTruthy();
    expect(comparator(arr2, sol2)).toBeTruthy();
  });

  it("handles more involved cases", function() {
    expect(comparator(arr3, sol3)).toBeTruthy();
  });

});
