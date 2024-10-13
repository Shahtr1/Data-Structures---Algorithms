package _4_singly_linked_list;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList implements ISinglyLinkedList {
    private ListNode head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode pointer = head;
        while (pointer != null) {
            String delimiter = " -> ";
            if (pointer.next == null) {
                delimiter = "";
            }
            System.out.print(pointer.data + delimiter);
            pointer = pointer.next;
        }
    }

    public List<Integer> getListOfInts() {
        List<Integer> resList = new ArrayList<>();
        if (head == null) {
            return resList;
        }
        ListNode pointer = head;
        while (pointer != null) {
            resList.add(pointer.data);
            pointer = pointer.next;
        }
        return resList;
    }

    public ListNode getNodeAtIndex(int index) {
        if (size == 0) {
            throw new IllegalStateException("Cannot retrieve node from an empty list");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index " + index + " can't be negative");
        }
        ListNode pointer = head;
        while (pointer != null && index != 0) {
            index--;
            pointer = pointer.next;
        }
        return pointer;
    }

    public ListNode getLastNodeOfList() {
        if (size == 0) {
            throw new IllegalStateException("Cannot retrieve node from an empty list");
        }
        ListNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public void addNode(ListNode node) {
        if (size == 0) {
            head = node;
        } else {
            ListNode pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }
        size++;
    }

    public void addNode(ListNode node, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index " + index + " can't be negative");
        }
        if (index == size) {
            addNode(node);
        } else {
            ListNode pointer = head;
            if (index == 0) {
                head = node;
                node.next = pointer;
                size++;
                return;
            }
            ListNode indexNode = getNodeAtIndex(index - 1);
            ListNode temp = indexNode.next;
            indexNode.next = node;
            node.next = temp;
            size++;
        }
    }

    public void deleteNode() {
        if (size == 0) {
            throw new IllegalStateException("Cannot delete node from an empty list");
        }
        if (size == 1) {
            head = null;
            size--;
            return;
        }
        ListNode indexNode = getNodeAtIndex(size - 2);
        indexNode.next = null;
        size--;
    }

    public void deleteNode(int index) {
        if (size == 0) {
            throw new IllegalStateException("Cannot delete node from an empty list");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index " + index + " can't be negative");
        }
        if (index == 0) {
            head = null;
            size--;
            return;
        }
        ListNode pointer = head;
        ListNode nextPointer = head.next;
        while (index != 1) {
            index--;
            pointer = pointer.next;
            nextPointer = nextPointer.next;
        }
        pointer.next = nextPointer.next;
        nextPointer = null;
        size--;
    }

    public void reverse() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            return;
        }
        int index = size;
        ListNode prevNode = null;
        ListNode nextNode = head;
        while (index != 0) {
            ListNode upcomingNode = nextNode.next;
            nextNode.next = prevNode;
            prevNode = nextNode;
            if (upcomingNode != null)
                nextNode = upcomingNode;
            index--;
        }
        head = nextNode;
    }
}
