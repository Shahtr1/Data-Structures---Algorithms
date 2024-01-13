function mergeSortedArrays(array1, array2) {
  const mergedArray = [];

  if (array1.length === 0) {
    return array2;
  }

  if (array2.length === 0) {
    return array1;
  }

  let array1Pointer = 0;
  let array2Pointer = 0;
  let array1Item = array1[array1Pointer];
  let array2Item = array2[array2Pointer];

  while (array1Item || array2Item) {
    if (!array2Item || array1Item < array2Item) {
      mergedArray.push(array1Item);
      array1Item = array1[++array1Pointer];
    } else {
      mergedArray.push(array2Item);
      array2Item = array2[++array2Pointer];
    }
  }

  return mergedArray;
}

const arr1 = [0, 1, 5, 9, 22];
const arr2 = [2, 3, 4, 7, 7, 21];

console.log(mergeSortedArrays(arr1, arr2));
