class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.first = null;
    this.last = null;
    this.length = 0;
  }

  peek() {
    return this.first;
  }

  enqueue(value) {
    const newNode = new Node(value);
    if (this.length === 0) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    }

    this.length++;
  }

  dequeue() {
    if (!this.first) {
      return null;
    }

    this.first = this.first.next;
    if (!this.first) {
      this.last = null;
    }
    this.length--;
  }

  isEmpty() {
    return !this.first && !this.last;
  }
}

const myQueue = new Queue();
myQueue.enqueue("person1");
myQueue.enqueue("person2");
myQueue.enqueue("person3");
myQueue.dequeue();
myQueue.dequeue();
myQueue.enqueue("person4");
myQueue.enqueue("person5");
myQueue.dequeue();
myQueue.dequeue();
myQueue.dequeue();
console.log(myQueue.isEmpty());
console.log(myQueue);
