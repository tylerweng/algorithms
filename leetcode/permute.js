/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    if (nums.length === 0) return [[]];
    let perms = [];
    let first = nums[0];
    let withoutFirst = permute(nums.slice(1));
    withoutFirst.forEach(perm => {
       for (let i = 0; i <= perm.length; i++) {
           perms.push(perm.slice(0, i).concat(first).concat(perm.slice(i)));
       }
    });
    return perms;
};

const numDerangements = n => {
    if (n === 0) return 1;
    if (n === 1) return 0;
    if (n === 2) return 1;
    return (n - 1) * (numDerangements(n - 2) + numDerangements(n - 1));
}
