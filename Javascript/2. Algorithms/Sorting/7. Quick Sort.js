// Example array to be sorted
const numbers = [3, 7, 8, 5, 2, 1, 9, 5, 4];

function quickSort(array, left, right) {
  // Base case: If the left index is less than the right, there's work to do
  if (left < right) {
    // Choosing the pivot as the right-most element
    const pivot = right;
    // Partitioning the array and getting the partition index
    const partitionIndex = partition(array, pivot, left, right);

    // Recursively sorting the left part of the array
    quickSort(array, left, partitionIndex - 1);
    // Recursively sorting the right part of the array
    quickSort(array, partitionIndex + 1, right);
  }
  return array;
}

function partition(array, pivot, left, right) {
  // Getting the pivot value
  const pivotValue = array[pivot];
  let partitionIndex = left;

  // Comparing other array items against the pivot value
  for (let i = left; i < right; i++) {
    if (array[i] < pivotValue) {
      // Swapping elements to ensure elements smaller than pivot are on the left
      swap(array, i, partitionIndex);
      partitionIndex++;
    }
  }
  // Moving the pivot to its correct position
  swap(array, right, partitionIndex);
  return partitionIndex;
}

function swap(array, firstIndex, secondIndex) {
  // Simple swap function
  var temp = array[firstIndex];
  array[firstIndex] = array[secondIndex];
  array[secondIndex] = temp;
}

// Initiate quicksort on the entire array
quickSort(numbers, 0, numbers.length - 1);
console.log(numbers);
