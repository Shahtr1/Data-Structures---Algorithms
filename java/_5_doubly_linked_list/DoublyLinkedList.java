package _5_doubly_linked_list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtBeginning(1);
        doublyLinkedList.insertAtBeginning(10);
        doublyLinkedList.insertAtEnd(100);
        doublyLinkedList.insertAtEnd(200);

        doublyLinkedList.printForward();
        doublyLinkedList.printBackward();

        doublyLinkedList.deleteFirstNode();
        doublyLinkedList.printForward();

        doublyLinkedList.deleteLastNode();
        doublyLinkedList.printForward();
    }

    public boolean isEmpty() {
        return length == 0; // head == null
    }

    public int length() {
        return length;
    }

    public void printForward() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }

        System.out.print("null");
        System.out.println("");
    }

    public void printBackward() {
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }

        System.out.print("null");
        System.out.println("");
    }

    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public ListNode deleteFirstNode() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLastNode() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = tail;
        if (head == tail) {
            tail = null;
        } else {
            tail.previous.next = null;
        }
        tail = head.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    private static class ListNode {
        int data;
        ListNode previous;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

}
