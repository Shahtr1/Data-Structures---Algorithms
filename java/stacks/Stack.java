package stacks;

import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    private void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    private int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        var temp = top;
        top = top.next;
        length--;
        return temp.data;
    }

    private void print() {
        ListNode current = top;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    private int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();
        stack.pop();

        stack.print();
        System.out.println("length is " + stack.length);
    }

}
