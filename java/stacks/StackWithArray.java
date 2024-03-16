package stacks;

import java.util.EmptyStackException;

public class StackWithArray {
    private int top;
    private int[] arr;

    public StackWithArray(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public StackWithArray() {
        this(10);
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return arr.length == size();
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int temp = arr[top];
        top--;
        return temp;
    }

    public String print() {
        String result = "";
        for (var item : arr) {
            result += item + "-->";
        }
        return result;
    }

    public int peek() {
        if (top < 0) {
            throw new EmptyStackException();
        }

        return arr[top];
    }

    public static void main(String[] args) {
        StackWithArray stackWithArray = new StackWithArray();
        stackWithArray.push(0);
        stackWithArray.push(1);
        stackWithArray.push(2);
        stackWithArray.pop();
        stackWithArray.pop();
        stackWithArray.push(3);
        stackWithArray.push(4);

        System.out.println(stackWithArray.print());
    }
}
