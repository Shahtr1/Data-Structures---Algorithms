// 3! = 3 x 2 x 1;

function findFactorialRecursive(number) {
  const newNumber = number - 1;
  let answer = 1;
  if (newNumber > 0) {
    answer = number * findFactorialRecursive(newNumber);
  }
  return answer;
}

function findFactorialIterative__WhileLoop(number) {
  let answer = 1;
  while (number > 1) {
    answer = answer * number;
    number--;
  }
  return answer;
}

function findFactorialIterative__ForLoop(number) {
  let answer = 1;
  for (let i = 2; i <= number; i++) {
    answer = answer * i;
  }
  return answer;
}

console.log(findFactorialRecursive(5));
console.log(findFactorialIterative__WhileLoop(2));
console.log(findFactorialIterative__ForLoop(2));
