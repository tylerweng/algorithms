describe("knapsack", function() {
  const knapsack = require("../lib/knapsack");

  const v1 = [92, 57, 49, 68, 60, 43, 67, 84, 87, 72];
  const w1 = [23, 31, 29, 44, 53, 38, 63, 85, 89, 82];
  const v2 = [24, 13, 23, 15, 16];
  const w2 = [12, 7, 11, 8, 9];

  it("handles trivial cases", function() {
    expect(knapsack(v1, w1, 0)).toEqual(0);
    expect(knapsack(v1, w1, 23)).toEqual(92);
  });

  it("handles more involved cases", function() {
    expect(knapsack(v1, w1, 165)).toEqual(309);
    expect(knapsack(v2, w2, 26)).toEqual(51);
  });

});
