package _12_singly_linked_list;

import java.util.NoSuchElementException;
import java.util.Optional;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void print() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    private int length() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private void insertAtBeginning(ListNode newNode) {
        newNode.next = head;
        head = newNode;
    }

    private void insertAtEnd(ListNode newNode) {
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;

    }

    private Optional<ListNode> getNodeAtIndex(int index) {
        int count = 0;
        ListNode currentNode = head;
        while (count != index) {
            currentNode = currentNode.next;
            count++;
        }

        return Optional.ofNullable(currentNode);
    }

    private void insertAtPosition(ListNode newNode, int position) {
        if (position == 0) {
            insertAtBeginning(newNode);
        } else if (position == length()) {
            insertAtEnd(newNode);
        } else if (position > length() || position < 0) {
            throw new IllegalArgumentException("Invalid position");
        } else {
            int count = 0;
            ListNode currentNode = head;
            while (count != position - 1) {
                currentNode = currentNode.next;
                count++;
            }
            ListNode temp = currentNode.next;
            currentNode.next = newNode;
            newNode.next = temp;
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);

        ListNode secondNode = new ListNode(1);
        ListNode thirdNode = new ListNode(8);
        ListNode fourthNode = new ListNode(11);

        singlyLinkedList.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        singlyLinkedList.print();
        System.out.println("length is: " + singlyLinkedList.length());

        ListNode zeroNode = new ListNode(90);
        singlyLinkedList.insertAtBeginning(zeroNode);

        singlyLinkedList.print();
        System.out.println("length after insert is: " + singlyLinkedList.length());

        ListNode endNode = new ListNode(150);
        singlyLinkedList.insertAtEnd(endNode);

        singlyLinkedList.print();
        System.out.println("length after insert is: " + singlyLinkedList.length());

        ListNode receivedNode = singlyLinkedList.getNodeAtIndex(0)
                .orElseThrow(() -> new NoSuchElementException("No node found at the given index"));

        System.out.println(receivedNode.data);

        ListNode insertAtPosition4 = new ListNode(450);
        singlyLinkedList.insertAtPosition(insertAtPosition4, 4);

        singlyLinkedList.print();
        System.out.println("length after insert is: " + singlyLinkedList.length());

    }

}
