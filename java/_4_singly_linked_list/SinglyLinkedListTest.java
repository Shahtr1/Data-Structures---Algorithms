package _4_singly_linked_list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

    @Test
    void testGetListOfStrings_whenAddedThreeNodes_shouldHaveListOfThreeEntries() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));

        String[] dataArray = singlyLinkedList.getListOfStrings().toArray(new String[0]);

        checkStringArray(dataArray, 3);

    }

    @Test
    void testSize_whenListIsEmpty_returnZero() {
        assertEquals(singlyLinkedList.size(), 0);
    }

    @Test
    void testSize_whenListhasTwoNodes_returnTwo() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        assertEquals(2, singlyLinkedList.size());
    }

    @Test
    void testGetLastNodeOfList_whenNoNodes_shouldReturnEmpty() {
        assertTrue(singlyLinkedList.getLastNodeOfList().isEmpty());
    }

    @Test
    void testGetLastNodeOfList_whenThreeNodes_shouldReturnLastNode() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        assertEquals("3", singlyLinkedList.getLastNodeOfList().get().data);
    }

    @Test
    void testGetNodeAtIndex_whenListIsEmpty_shouldReturnMessage() {
        Optional<ListNode> node = singlyLinkedList.getNodeAtIndex(4);
        assertTrue(node.isEmpty());
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsGreaterOrEqualToSizeOfList_shouldReturnEmpty() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        Optional<ListNode> node = singlyLinkedList.getNodeAtIndex(4);
        assertTrue(node.isEmpty());
        node = singlyLinkedList.getNodeAtIndex(3);
        assertTrue(node.isEmpty());
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsNegative_shouldReturnMessage() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        Optional<ListNode> node = singlyLinkedList.getNodeAtIndex(-2);
        assertTrue(node.isEmpty());
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsProvided_shouldReturnData() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        singlyLinkedList.addNode(new ListNode("4"));

        String data = singlyLinkedList.getNodeAtIndex(2).get().data;
        assertEquals("3", data);

        data = singlyLinkedList.getNodeAtIndex(3).get().data;
        assertEquals("4", data);

    }

    @Test
    void testAddNode_whenNoIndexProvided_shouldAddAtTheEnd() {

        singlyLinkedList.addNode(new ListNode("1"));
        assertEquals("1", singlyLinkedList.getLastNodeOfList().get().data);

        singlyLinkedList.addNode(new ListNode("2"));
        assertEquals("2", singlyLinkedList.getLastNodeOfList().get().data);

        singlyLinkedList.addNode(new ListNode("3"));
        assertEquals("3", singlyLinkedList.getLastNodeOfList().get().data);
    }

    @Test
    void testAddNode_whenIndexGreaterThanSizeOrNegative_listSizeShouldNotChange() {
        singlyLinkedList.addNode(new ListNode("1"), 4);

        int size = singlyLinkedList.size();

        assertEquals(0, size);

        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));

        singlyLinkedList.addNode(new ListNode("4"), 4);

        size = singlyLinkedList.size();

        assertEquals(3, size);
        assertEquals("3", singlyLinkedList.getLastNodeOfList().get().data);

        singlyLinkedList.addNode(new ListNode("100"), -10);

        size = singlyLinkedList.size();

        assertEquals(3, size);
        assertEquals("3", singlyLinkedList.getLastNodeOfList().get().data);

    }

    @Test
    void testAddNode_whenIndexEqualsToSize_listShouldAdd() {
        int size = singlyLinkedList.size();
        singlyLinkedList.addNode(new ListNode("1"), size);
        assertEquals("1", singlyLinkedList.getLastNodeOfList().get().data);

        size = singlyLinkedList.size();
        singlyLinkedList.addNode(new ListNode("2"), size);
        assertEquals("2", singlyLinkedList.getLastNodeOfList().get().data);

        size = singlyLinkedList.size();
        singlyLinkedList.addNode(new ListNode("3"), size);
        assertEquals("3", singlyLinkedList.getLastNodeOfList().get().data);

    }

    @Test
    void testAddNode_whenIndexProvided_listShouldAdd() {

        singlyLinkedList.addNode(new ListNode("1"), 0);
        singlyLinkedList.addNode(new ListNode("2"), 1);
        singlyLinkedList.addNode(new ListNode("3"), 2);
        singlyLinkedList.addNode(new ListNode("5"));
        singlyLinkedList.addNode(new ListNode("6"));
        singlyLinkedList.addNode(new ListNode("4"), 3);
        singlyLinkedList.addNode(new ListNode("7"), 6);
        singlyLinkedList.addNode(new ListNode("10"));
        singlyLinkedList.addNode(new ListNode("9"), 7);
        singlyLinkedList.addNode(new ListNode("8"), 7);
        singlyLinkedList.addNode(new ListNode("11"), 10);

        String[] dataArray = singlyLinkedList.getListOfStrings().toArray(new String[0]);

        checkStringArray(dataArray, 11);

    }

    private void checkStringArray(String[] dataArray, int length) {
        IntStream.range(0, length).forEach(index -> {
            assertEquals(index + 1 + "", dataArray[index]);
        });

    }

}
