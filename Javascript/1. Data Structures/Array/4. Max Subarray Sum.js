var maxSubArray__Linear = function (nums) {
  let currentSum = nums[0];

  let maxSum = nums[0];
  for (let i = 1; i < nums.length; i++) {
    currentSum = Math.max(nums[i], currentSum + nums[i]);
    maxSum = Math.max(maxSum, currentSum);
  }

  return maxSum;
};

var maxSubArray__DivideAndConquer = function (nums) {
  // Base Case
  if (nums.length === 1) {
    return nums[0];
  }

  let mid = Math.floor(nums.length / 2);

  let leftMax = maxSubArray__DivideAndConquer(nums.slice(0, mid));
  let rightMax = maxSubArray__DivideAndConquer(nums.slice(mid));

  let crossingMax = getCrossingMax(nums, mid);

  return Math.max(leftMax, rightMax, crossingMax);
};

function getCrossingMax(nums, mid) {
  let leftSum = -Infinity;
  let rightSum = -Infinity;

  let sum = 0;

  for (let i = mid - 1; i >= 0; i--) {
    sum += nums[i];
    if (sum > leftSum) {
      leftSum = sum;
    }
  }

  sum = 0;

  for (let i = mid; i < nums.length; i++) {
    sum += nums[i];
    if (sum > rightSum) {
      rightSum = sum;
    }
  }

  return leftSum + rightSum;
}

const testArr1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4];
// return 6 from subarray [4, -1, 2, 1]

const testArr2 = [1]; // return 1

const testArr3 = [5, 4, -1, 7, 8];
// return 23 from subarray [5, 4, -1, 7, 8]

const testArr4 = [-1];

console.log(maxSubArray__Linear(testArr1)); // O(n)
console.log(maxSubArray__DivideAndConquer(testArr1)); // O(nlog(n))
