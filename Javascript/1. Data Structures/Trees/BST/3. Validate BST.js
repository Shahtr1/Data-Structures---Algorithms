// https://leetcode.com/problems/validate-binary-search-tree/

/*
    Input: root = [2,1,3]
    Output: true

    Input: root = [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.
*/

function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

var isValidBST = function (root) {
  const traversedList = [];
  const getValues = (rootNode, list) => {
    if (rootNode.left) {
      getValues(rootNode.left, list);
    }

    list.push(rootNode.val);

    if (rootNode.right) {
      getValues(rootNode.right, list);
    }

    return list;
  };

  getValues(root, traversedList);

  for (let i = 1; i < traversedList.length; i++) {
    if (traversedList[i] <= traversedList[i - 1]) {
      return false;
    }
  }

  return true;
};

console.log(
  isValidBST({
    val: 2,
    left: { val: 1, left: null, right: null },
    right: { val: 3, left: null, right: null },
  })
);
