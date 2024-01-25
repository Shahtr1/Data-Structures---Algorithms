// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233 ...

let calculations = 0;
function fibonacci(n) {
  calculations++;
  if (n < 2) {
    return n;
  }

  return fibonacci(n - 1) + fibonacci(n - 2);
}

function fibonacciMaster() {
  calculations = 0;
  let cache = {};
  return function fib(n) {
    calculations++;
    if (n in cache) {
      // cache hit
      return cache[n];
    } else {
      if (n < 2) {
        return n;
      } else {
        // cache miss
        cache[n] = fib(n - 1) + fib(n - 2);
        return cache[n];
      }
    }
  };
}

fibonacci(35); // O(2^n)
// fibonacci(100); // this will crash browser
console.log("slow calculations", calculations);

const fasterFib = fibonacciMaster();
fasterFib(100); // O(n)

console.log("fast calculations", calculations);
