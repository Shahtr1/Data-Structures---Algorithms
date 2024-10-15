package _4_singly_linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SinglyLinkedList implements ISinglyLinkedList {
    private ListNode head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public ListNode getHead() {
        return head;
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
        while (index != 0) {
            index--;
            pointer = pointer.next;
        }
        return pointer;
    }

    public ListNode getNodeAtIndexFromEnd(int indexToFind) {
        if (size == 0) {
            throw new IllegalStateException("Cannot retrieve node from an empty list");
        }
        if (indexToFind >= size) {
            throw new IndexOutOfBoundsException("Index " + indexToFind + " is out of bounds");
        }
        if (indexToFind < 0) {
            throw new IllegalArgumentException("Index " + indexToFind + " can't be negative");
        }

        int counter = 1;
        ListNode pointer = head;
        while (size - counter != indexToFind) {
            counter++;
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

    public void removeDuplicates() {
        Map<Integer, Boolean> valueHolder = new HashMap<>();
        ListNode pointer = null;
        ListNode nextPointer = head;

        while (nextPointer != null) {
            if (valueHolder.get(nextPointer.data) != null) {
                pointer.next = nextPointer.next;
                nextPointer = nextPointer.next;
                size--;
            } else {
                valueHolder.put(nextPointer.data, true);
                pointer = nextPointer;
                nextPointer = nextPointer.next;
            }

        }

        for (Entry<Integer, Boolean> entry : valueHolder.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("end" + size);

    }

    public boolean hasLoop() {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        if (size == 0) {
            return false;
        }

        do {
            if (fastPointer.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        } while (!slowPointer.equals(fastPointer));

        return true;
    }

    public SinglyLinkedList mergeTwoSortedLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList resList = new SinglyLinkedList();

        if (list1.size == 0 && list2.size == 0) {
            return resList;
        }

        if (list1.size == 0) {
            return list2;
        }

        if (list2.size == 0) {
            return list1;
        }

        ListNode firstPointer = list1.head;
        ListNode secondPointer = list2.head;

        while (firstPointer != null && secondPointer != null) {
            if (firstPointer.data < secondPointer.data) {
                resList.addNode(new ListNode(firstPointer.data));
                firstPointer = firstPointer.next;
            } else {
                resList.addNode(new ListNode(secondPointer.data));
                secondPointer = secondPointer.next;
            }
        }

        if (firstPointer != null) {
            resList.addNode(firstPointer);
        } else if (secondPointer != null) {
            resList.addNode(secondPointer);
        }

        return resList;
    }
}
