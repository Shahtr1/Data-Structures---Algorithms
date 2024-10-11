package _4_singly_linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SinglyLinkedList {
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
            String delimeter = " -> ";
            if (pointer.next == null) {
                delimeter = "";
            }
            System.out.print(pointer.data + delimeter);
            pointer = pointer.next;
        }
    }

    public List<String> getListOfStrings() {

        List<String> resList = new ArrayList<>();

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

    public Optional<ListNode> getNodeAtIndex(int index) {

        if (size == 0) {
            System.err.println("List is empty");
            return Optional.empty();
        }

        if (index >= size) {
            System.err.println("Index out of bounds");
            return Optional.empty();
        }

        if (index < 0) {
            System.err.println("Index can't be negative");
            return Optional.empty();
        }

        ListNode pointer = head;

        while (pointer != null && index != 0) {
            index--;
            pointer = pointer.next;
        }

        return Optional.of(pointer);

    }

    public Optional<ListNode> getLastNodeOfList() {
        if (head == null) {
            return Optional.empty();
        }

        ListNode pointer = head;

        while (pointer.next != null) {
            pointer = pointer.next;
        }

        return Optional.of(pointer);
    }

    public void addNode(ListNode node) {
        if (head == null) {
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
        if (index > size || index < 0) {
            System.err.println("Index out of bounds");
            return;
        }

        if (index == size) {
            // Add at the end
            addNode(node);
        } else {
            ListNode pointer = head;

            if (index == 0) {
                head = node;
                node.next = pointer;
                size++;
                return;
            }

            ListNode indexNode = getNodeAtIndex(index - 1).get();
            ListNode temp = indexNode.next;
            indexNode.next = node;
            node.next = temp;
            size++;

        }
    }

}
