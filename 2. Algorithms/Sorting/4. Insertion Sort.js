// Some cases where its actually extremely fast
// when we are pretty sure that list is almost sorted, or already sorted,
// best case we get O(n) linear time.
// really well with small data sets
const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function insertionSort(array) {
  for (let i = 1; i < array.length; i++) {
    if (array[i] < array[0]) {
      array.unshift(array.splice(i, 1)[0]);
    } else
      for (let j = i; j >= 0; j--) {
        if (array[j - 1] > array[j]) {
          const temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
  }
}

insertionSort(numbers); // O(n^2)
console.log(numbers);
