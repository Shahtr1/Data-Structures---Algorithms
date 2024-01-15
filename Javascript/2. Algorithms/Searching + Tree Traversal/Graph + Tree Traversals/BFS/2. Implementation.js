class Node {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  insert(value) {
    const newNode = new Node(value);
    if (!this.root) {
      this.root = newNode;
    } else {
      let currentNode = this.root;
      while (true) {
        if (value < currentNode.value) {
          if (!currentNode.left) {
            currentNode.left = newNode;
            return this;
          } else {
            currentNode = currentNode.left;
          }
        } else if (value > currentNode.value) {
          if (!currentNode.right) {
            currentNode.right = newNode;
            return this;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
  }

  lookup(value) {
    if (!this.root) {
      return false;
    }

    if (this.root.value === value) {
      return this.root;
    } else {
      let currentNode = this.root;
      while (currentNode) {
        if (value < currentNode.value) {
          this.parent = currentNode;
          currentNode = currentNode.left;
        } else if (value > currentNode.value) {
          this.parent = currentNode;
          currentNode = currentNode.right;
        } else if (currentNode.value === value) {
          return currentNode;
        }
      }
      return false;
    }
  }

  remove(value) {
    if (!this.root) {
      return false;
    }

    let currentNode = this.root;
    let parentNode = null;

    while (currentNode) {
      if (value < currentNode.value) {
        parentNode = currentNode;
        currentNode = currentNode.left;
      } else if (value > currentNode.value) {
        parentNode = currentNode;
        currentNode = currentNode.right;
      } else if (currentNode.value === value) {
        // No right child
        if (!currentNode.right) {
          if (!parentNode) {
            this.root = currentNode.left;
          } else {
            if (currentNode.value < parentNode.value) {
              parentNode.left = currentNode.left;
            } else if (currentNode.value > parentNode.value) {
              parentNode.right = currentNode.left;
            }
          }
        }

        // Right child which doesnt have a left child
        else if (!currentNode.right.left) {
          if (!parentNode) {
            this.root = currentNode.left;
          } else {
            currentNode.right.left = currentNode.left;
            if (currentNode.value < parentNode.value) {
              parentNode.left = currentNode.right;
            } else if (currentNode.value > parentNode.value) {
              parentNode.right = currentNode.right;
            }
          }
        }

        // Right child that has a left child
        else {
          //  find the right child's left most child
          let leftMost = currentNode.right.left;
          let leftMostParent = currentNode.right;
          while (leftMost.left) {
            leftMostParent = leftMost;
            leftMost = leftMost.left;
          }

          //   Parent's left subtree is now leftmost's right subtree
          leftMostParent.left = leftMost.right;
          leftMost.left = currentNode.left;
          leftMost.right = currentNode.right;

          if (parentNode === null) {
            this.root = leftMost;
          } else {
            if (currentNode.value < parentNode.value) {
              parentNode.left = leftMost;
            } else if (currentNode.value > parentNode.value) {
              parentNode.right = leftMost;
            }
          }
        }

        return true;
      }
    }
  }

  // Implementation
  breadthFirstSearch() {
    let currentNode = this.root;
    let list = [];
    let queue = []; // to keep track of the level
    // This queue can get pretty large, because we need to add child to queue, if we have very wide tree, many child nodes
    queue.push(currentNode);

    while (queue.length > 0) {
      currentNode = queue.shift(); // take first item in the queue and remove it
      list.push(currentNode.value);
      if (currentNode.left) {
        queue.push(currentNode.left);
      }
      if (currentNode.right) {
        queue.push(currentNode.right);
      }
    }

    console.log("BFS list:", list);
  }

  breadthFirstSearchRecursively(queue, list) {
    if (!queue.length) {
      console.log("BFS list recursively:", list);
      return;
    }

    let currentNode = queue.shift();
    list.push(currentNode.value);
    if (currentNode.left) {
      queue.push(currentNode.left);
    }
    if (currentNode.right) {
      queue.push(currentNode.right);
    }

    return this.breadthFirstSearchRecursively(queue, list);
  }
}

const myTree = new BinarySearchTree();
myTree.insert(9);
myTree.insert(4);
myTree.insert(6);
myTree.insert(20);
myTree.insert(170);
myTree.insert(15);
myTree.insert(1);
myTree.remove(20);
myTree.breadthFirstSearch();
myTree.breadthFirstSearchRecursively([myTree.root], []);
console.log(myTree.root);

// console.log(myTree.lookup(6));

//       9
//   4       20
// 1   6  15   170

/**
    BFS[ 9, 4, 170, 1, 6, 15 ]
 */
