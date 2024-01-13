// Least efficient
const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function selectionSort(array) {
  if (array.length < 2) {
    return array;
  }
  for (let j = 0; j < array.length; j++) {
    let smallestIndex = j;
    for (let i = j; i < array.length; i++) {
      if (array[i] < array[smallestIndex]) {
        smallestIndex = i;
      }
    }
    const temp = array[j];
    array[j] = array[smallestIndex];
    array[smallestIndex] = temp;
  }
}

selectionSort(numbers); // O(n^2) , O(1)
console.log(numbers);
