// Methods to represent graphs

//  Edge List
const graph1 = [
  [0, 2],
  [2, 3],
  [2, 1],
  [1, 3],
];

// Adjacent List
const graph2 = [[2], [2, 3], [0, 1, 3], [1, 2]];

// Adjacent Matrix, we can use weights inplace of 0's and 1's
const graph3 = [
  [0, 0, 1, 0],
  [0, 0, 1, 1],
  [1, 1, 0, 1],
  [0, 1, 1, 0],
];

// or we can use the above with key and value

const graph4 = {
  0: [0, 0, 1, 0],
  1: [0, 0, 1, 1],
  2: [1, 1, 0, 1],
  3: [0, 1, 1, 0],
};
