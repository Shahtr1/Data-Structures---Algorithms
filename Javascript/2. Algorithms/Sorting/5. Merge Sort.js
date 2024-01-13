// O( n log n )
// One of the most efficient approach to sort list

const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function mergeSort(array) {
  if (array.length === 1) {
    return array;
  }

  const separatorIndex = Math.floor(array.length / 2);

  const left = array.slice(0, separatorIndex);
  const right = array.slice(separatorIndex, array.length);

  return merge(mergeSort(left), mergeSort(right));
}

// merge sorted arrays
function merge(left, right) {
  const mergedArray = [];
  let leftCounter = 0;
  let leftItem = left[leftCounter];

  let rightCounter = 0;
  let rightItem = right[rightCounter];

  while (leftItem && rightItem) {
    if (leftItem > rightItem) {
      mergedArray.push(rightItem);
      rightItem = right[++rightCounter];
    } else {
      mergedArray.push(leftItem);
      leftItem = left[++leftCounter];
    }
  }

  if (!leftItem && rightItem) {
    for (let i = rightCounter; i < right.length; i++) {
      mergedArray.push(right[i]);
    }
  } else if (leftItem && !rightItem) {
    for (let i = leftCounter; i < left.length; i++) {
      mergedArray.push(left[i]);
    }
  }

  return mergedArray;
}

console.log(mergeSort(numbers));
