// Given

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...

// O(n)
function fibonacciIterative_WhileLoop(n) {
  let nextValue = 1;
  let previousValue = 0;
  let counter = 2;

  if (n < 2) {
    return n;
  }
  while (counter <= n) {
    const temp = nextValue;
    nextValue = nextValue + previousValue;
    previousValue = temp;
    counter++;
  }

  return nextValue;
}

console.log(fibonacciIterative_WhileLoop(12));

// O(n)
function fibonacciIterative_ForLoop(n) {
  let arr = [0, 1];
  for (let i = 2; i < n + 1; i++) {
    arr.push(arr[i - 2] + arr[i - 1]);
  }

  return arr[n];
}

console.log(fibonacciIterative_ForLoop(12));

// Exponential growth -> O(2^n)
function fibonacciRecursive(n) {
  if (n < 2) {
    return n;
  }

  return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

console.log(fibonacciRecursive(40));
// 1099511627776 calculations
