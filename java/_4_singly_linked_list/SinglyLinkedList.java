package _4_singly_linked_list;

public class SinglyLinkedList {
    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.printList();
        System.out.println("Size is " + singlyLinkedList.size());

        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        singlyLinkedList.addNode(new ListNode("5"));
        singlyLinkedList.addNode(new ListNode("6"));

        singlyLinkedList.addNode(new ListNode("4"), 3);

        singlyLinkedList.printList();
        System.out.println();
        System.out.println("Size is " + singlyLinkedList.size());

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

    public int size() {
        int size = 0;
        if (head == null)
            return size;

        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }

        return size;
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
    }

    public void addNode(ListNode node, int index) {
        // size = 3, index = 2
        var size = size();

        if (index > size) {
            System.err.println("Index out of bounds");
            return;
        }

        if (head == null) {
            head = node;
        } else if (index == size) {
            // Add at the end
            addNode(node);
        } else {

        }
    }

    private static class ListNode {
        private String data;
        private ListNode next;

        private ListNode(String data) {
            this.data = data;
        }

    }

}
