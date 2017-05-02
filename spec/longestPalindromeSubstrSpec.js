describe("longestPalindromeSubstr", function() {
  const longestPalindromeSubstr = require("../lib/longestPalindromeSubstr");

  const s1 = "";
  const s2 = "a"
  const s3 = "abccbz"
  const s4 = "abcdcbaz"

  it("handles trivial cases", function() {
    expect(longestPalindromeSubstr(s1)).toEqual("");
    expect(longestPalindromeSubstr(s2)).toEqual("a");
  });

  it("handles more involved cases", function() {
    expect(longestPalindromeSubstr(s3)).toEqual("bccb");
    expect(longestPalindromeSubstr(s4)).toEqual("abcdcba");
  });


});
