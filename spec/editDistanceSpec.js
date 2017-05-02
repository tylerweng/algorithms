describe("editDistance", function() {
  const editDistance = require("../lib/editDistance");

  const str1a = "", str1b = "abc";
  const sol1 = 3;
  const str2a = "ab", str2b = "";
  const sol2 = 2;
  const str3a = "xyzecx", str3b = "racecar";
  const sol3 = 5;

  it("handles trivial cases", function() {
    expect(editDistance(str1a, str1b)).toEqual(sol1);
    expect(editDistance(str2a, str2b)).toEqual(sol2);
  });

  it("handles more involved cases", function() {
    expect(editDistance(str3a, str3b)).toEqual(sol3);
  });

});
