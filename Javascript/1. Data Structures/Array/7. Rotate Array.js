/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
  k = k % nums.length;
  // left
  reverse(0, nums.length - 1 - k, nums);

  // right
  reverse(nums.length - k, nums.length - 1, nums);

  //   // whole
  reverse(0, nums.length - 1, nums);
};

function reverse(start, end, array) {
  let counter = end;
  for (let i = start; i <= end; i++) {
    if (i > counter) {
      break;
    }
    const temp = array[i];
    array[i] = array[counter];
    array[counter] = temp;
    counter--;
  }
}

const testArr1 = [1, 2, 3, 4, 5, 6, 7];
const k1 = 3;
// Output: [5,6,7,1,2,3,4]

const testArr2 = [-1, -100, 3, 99];
const k2 = 2;
// Output: [3,99,-1,-100]

rotate(testArr2, k2);
console.log(testArr2);

/**

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]


Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

 */
