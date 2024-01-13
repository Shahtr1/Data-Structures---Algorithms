class Stack {
  constructor() {
    this.array = [];
  }

  peek() {
    return this.array[this.array.length - 1];
  }

  push(value) {
    this.array.push(value);
  }

  pop() {
    this.array.pop();
  }

  isEmpty() {
    return this.array.length === 0;
  }
}

const myStack = new Stack();
myStack.peek();
myStack.push("Google");
myStack.push("Udemy");
myStack.push("Discord");
myStack.pop();
myStack.pop();
myStack.pop();
console.log(myStack.isEmpty());
console.log("myStack", myStack);
