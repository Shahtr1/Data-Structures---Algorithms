package _7_stack;

import java.util.EmptyStackException;

public class Stack {

    private int size = 10;

    private int[] array = new int[size];

    private int top = -1;

    public Stack() {
    }

    public Stack(int size) {
        this.size = size;
        array = new int[this.size];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isFull() {
        return top == getSize() - 1;
    }

    public void push(int item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        array[++top] = item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int length() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }

}
