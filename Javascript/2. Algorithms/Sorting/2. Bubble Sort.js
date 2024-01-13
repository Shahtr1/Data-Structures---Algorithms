// Least efficient
const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function bubbleSort(array) {
  if (array.length < 2) {
    return array;
  }
  for (let j = 1; j < array.length; j++) {
    for (let i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        const temp = array[i];
        array[i] = array[i - 1];
        array[i - 1] = temp;
      }
    }
  }
}

bubbleSort(numbers); // O(n^2) , O(1)
console.log(numbers);
