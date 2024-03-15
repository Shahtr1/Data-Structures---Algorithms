package _12_singly_linked_list;

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

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);

        ListNode secondNode = new ListNode(20);
        ListNode thirdNode = new ListNode(30);
        ListNode fourthNode = new ListNode(40);

        singlyLinkedList.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
    }
}
