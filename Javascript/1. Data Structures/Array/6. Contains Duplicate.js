/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
  const obj = {};
  for (let i = 0; i < nums.length; i++) {
    if (obj[nums[i]]) {
      return true;
    }

    obj[nums[i]] = true;
  }

  return false;
};

const testArr1 = [1, 2, 3, 1]; // should output true
const testArr2 = [1, 2, 3, 4]; // should output false
const testArr3 = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]; // should output true

console.log(containsDuplicate(testArr1));
