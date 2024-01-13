class Queue {
  constructor() {
    this.first = [];
    this.last = [];
  }

  enqueue(value) {
    const length = this.first.length;
    for (let i = 0; i < length; i++) {
      this.last.push(this.first.pop());
    }

    this.last.push(value);
  }

  dequeue() {
    const length = this.last.length;
    for (let i = 0; i < length; i++) {
      this.first.push(this.last.pop());
    }

    this.first.pop();
  }

  peek() {
    if (this.first.length > 0) {
      return this.first[this.first.length - 1];
    }
    return this.last[0];
  }

  isEmpty() {
    return !this.first.length && !this.last.length;
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
console.log(myQueue.peek());
myQueue.dequeue();
console.log(myQueue.peek());
myQueue.dequeue();
myQueue.dequeue();
console.log(myQueue.isEmpty());
console.log(myQueue);
