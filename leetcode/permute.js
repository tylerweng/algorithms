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
