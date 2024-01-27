/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  let zeroCount = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 0) {
      zeroCount++;
    } else {
      if (zeroCount > 0) {
        nums[i - zeroCount] = nums[i];
        nums[i] = 0;
      }
    }
  }
};

const testArr1 = [0, 1, 0, 3, 12]; // should output [1,3,12,0,0]
const testArr2 = [0]; // should output [0]
const testArr3 = [1]; // should output [1]

moveZeroes(testArr3);
console.log(testArr3);
