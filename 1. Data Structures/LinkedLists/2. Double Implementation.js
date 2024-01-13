/** 
    10-->5-->16
*/

/** 
    let myLinkedList = {
        head: {
            value: 10,
            next: {
                value: 5,
                next: {
                    value: 16,
                    next: null,
                },
            },
        },
    };
*/

class LinkedList {
  constructor(value) {
    this.head = {
      value,
      prev: null,
      next: null,
    };
    this.tail = this.head;
    this.length = 1;
  }

  append(value) {
    const newNode = { value, next: null, prev: this.tail };
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;
    return this;
  }

  prepend(value) {
    const newNode = { value, next: this.head, prev: null };
    this.head.prev = newNode;
    this.head = newNode;
    this.length++;
    return this;
  }

  printList() {
    const array = [];
    let currentNode = this.head;
    console.log("currentNode", currentNode);

    while (currentNode !== null) {
      array.push(currentNode.value);
      currentNode = currentNode.next;
    }
    console.log(array);
  }

  insert(index, value) {
    if (index >= this.length) {
      return this.append(value);
    }

    if (index < 0) {
      return this.prepend(value);
    }

    const newNode = { value, next: null, prev: null };

    const currentNode = this.traverseToIndex(index);

    const holdingPointer = currentNode.next;

    currentNode.next = newNode;
    newNode.prev = currentNode;
    newNode.next = holdingPointer;
    holdingPointer.prev = newNode;
    this.length++;
  }

  traverseToIndex(index) {
    if (index > this.length && index < 0) {
      return;
    }

    let counter = 0;
    let currentNode = this.head;
    while (counter < index) {
      currentNode = currentNode.next;
      counter++;
    }
    return currentNode;
  }

  remove(index) {
    if (index > this.length - 1 || index < 0) {
      return;
    }

    if (index === 0) {
      this.head = this.head.next;
      this.head.prev = null;
    } else {
      const beforeCurrentNode = this.traverseToIndex(index - 1);
      const nodeToRemove = beforeCurrentNode.next;
      beforeCurrentNode.next = nodeToRemove.next;
    }
    this.length--;
  }

  reverse() {
    if (!this.head.next) {
      return this.head;
    }
    let first = this.head;
    this.tail = first;
    let second = first.next;
    while (second) {
      const temp = second.next;
      second.next = first;
      first.prev = second;
      first = second;
      second = temp;
    }

    this.head.next = null;
    this.head = first;
  }
}

const myLinkedList = new LinkedList(10);
myLinkedList.append(2);
myLinkedList.append(3);
myLinkedList.prepend(4);
myLinkedList.insert(1, 100);
myLinkedList.insert(-99, -876);
myLinkedList.insert(99999, 11111111111);
myLinkedList.append(15);
myLinkedList.append(36);
myLinkedList.remove(0);
myLinkedList.remove(5);

myLinkedList.reverse();

myLinkedList.printList();
console.log(myLinkedList);
