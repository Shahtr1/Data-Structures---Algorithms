// Google Question
// Give an array = [2,5,1,2,3,5,1,2,4];
// It should return 2

// Given an array = [2,1,1,2,3,5,1,2,4];
// It should return 1

// Given an array = [1,2,4,5]
// It should return undefined

function firstRecurringCharacter(array) {
  if (array && array.length) {
    let arrayObj = {};
    for (let i = 0; i < array.length; i++) {
      if (arrayObj[array[i]]) {
        return array[i];
      } else {
        arrayObj[array[i]] = true;
      }
    }
  } else console.error("Please add array as argument");
} // O(n)

const recurringCharacter = firstRecurringCharacter([2, 5, 1, 2, 3, 5, 1, 2, 4]);

console.log(recurringCharacter);
