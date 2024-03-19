package _12_singly_linked_list;

import java.util.NoSuchElementException;
import java.util.Optional;

public class _1_SinglyLinkedList {

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

    private Optional<ListNode> deleteFirst() {
        if (head == null) {
            return Optional.ofNullable(null);
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;

        return Optional.of(temp);
    }

    private Optional<ListNode> deleteLast() {
        if (head == null) {
            return Optional.ofNullable(null);
        }

        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;

        }

        previousNode.next = null;
        return Optional.of(currentNode);

    }

    private Optional<ListNode> deleteAtPosition(int position) {
        int count = 0;
        if (head == null) {
            return Optional.ofNullable(null);
        }

        ListNode currentNode = head;
        ListNode previousNode = null;

        while (count < position) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            count++;

        }
        ListNode temp = currentNode;
        previousNode.next = currentNode.next;

        return Optional.of(temp);

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

    private void reverseList() {
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode temp = null;
        while (currentNode != null) {
            temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }
        head = previousNode;
    }

    private void removeDuplicates() {
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }

        return temp;
    }

    // floyd's cycle detection algorithm
    private Integer getStartingPointOfLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                return getStartingNode(slowPtr).data;
            }

        }

        return null;

    }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr.next != temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }

        slowPtr.next = null;
    }

    private void removeLoopFromList() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
            }

        }

    }

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        _1_SinglyLinkedList singlyLinkedList = new _1_SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);

        ListNode secondNode = new ListNode(1);
        ListNode thirdNode = new ListNode(8);
        ListNode fourthNode = new ListNode(11);
        ListNode fifthNode = new ListNode(55);
        ListNode sixthNode = new ListNode(66);

        singlyLinkedList.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

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

        singlyLinkedList.deleteFirst();
        singlyLinkedList.print();
        System.out.println("length after deleting first is: " + singlyLinkedList.length());

        singlyLinkedList.deleteLast();
        singlyLinkedList.print();
        System.out.println("length after deleting last is: " + singlyLinkedList.length());

        singlyLinkedList.deleteAtPosition(2);
        singlyLinkedList.print();
        System.out.println("length after deleting at position 2 is: " + singlyLinkedList.length());
        System.out.println("length after deleting last is: " + singlyLinkedList.length());

        singlyLinkedList.deleteAtPosition(3);
        singlyLinkedList.print();
        System.out.println("length after deleting at position 3 is: " + singlyLinkedList.length());

        singlyLinkedList.reverseList();
        singlyLinkedList.print();

        /**
         * ******************
         * SORTED LINKED LIST
         * ******************
         */

        System.out.println("==================");
        System.out.println("SORTED LINKED LIST");
        System.out.println("==================");

        _1_SinglyLinkedList sortedLinkedList = new _1_SinglyLinkedList();
        sortedLinkedList.head = new ListNode(1);

        ListNode secondSortNode = new ListNode(1);
        ListNode thirdSortNode = new ListNode(2);
        ListNode fourthSortNode = new ListNode(3);
        ListNode fifthSortNode = new ListNode(3);

        sortedLinkedList.head.next = secondSortNode;
        secondSortNode.next = thirdSortNode;
        thirdSortNode.next = fourthSortNode;
        fourthSortNode.next = fifthSortNode;

        sortedLinkedList.print();

        sortedLinkedList.removeDuplicates();
        sortedLinkedList.print();

        /**
         * ******************
         * SORTED LINKED LIST
         * ******************
         */

        System.out.println("==================");
        System.out.println("DETECT LOOP IN LIST");
        System.out.println("==================");

        _1_SinglyLinkedList loopedLinkedList = new _1_SinglyLinkedList();
        loopedLinkedList.head = new ListNode(1);

        ListNode secondLoopedNode = new ListNode(2);
        ListNode thirdLoopedNode = new ListNode(3);
        ListNode fourthLoopedNode = new ListNode(4);
        ListNode fifthLoopedNode = new ListNode(5);
        ListNode sixthLoopedNode = new ListNode(6);

        sortedLinkedList.head.next = secondLoopedNode;
        secondLoopedNode.next = thirdLoopedNode;
        thirdLoopedNode.next = fourthLoopedNode;
        fourthLoopedNode.next = fifthLoopedNode;
        fifthLoopedNode.next = sixthLoopedNode;
        sixthLoopedNode.next = thirdLoopedNode;

        System.out.println("Starting point of loop is: " + sortedLinkedList.getStartingPointOfLoop());
        sortedLinkedList.removeLoopFromList();
        sortedLinkedList.print();

        /**
         * ******************
         * MERGE SORTED LINKED LISTS
         * ******************
         */

        System.out.println("=========================");
        System.out.println("MERGE SORTED LINKED LISTS");
        System.out.println("=========================");

        ListNode mergListNode = merge(sortedLinkedList.head, loopedLinkedList.head);

        System.out.println(mergListNode);

    }

}
