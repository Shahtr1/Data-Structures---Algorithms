package _4_singly_linked_list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
    private SinglyLinkedList singlyLinkedList;

    @BeforeEach
    void setUp() {
        singlyLinkedList = new SinglyLinkedList();
    }

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
        assertEquals(0, singlyLinkedList.getSize());
    }

    @Test
    void testSize_whenListHasTwoNodes_returnTwo() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        assertEquals(2, singlyLinkedList.getSize());
    }

    @Test
    void testGetLastNodeOfList_whenListIsEmpty_shouldThrowException() {
        assertThrows(IllegalStateException.class, () -> singlyLinkedList.getLastNodeOfList());
    }

    @Test
    void testGetLastNodeOfList_whenThreeNodes_shouldReturnLastNode() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        assertEquals("3", singlyLinkedList.getLastNodeOfList().data);
    }

    @Test
    void testGetNodeAtIndex_whenListIsEmpty_shouldThrowException() {
        assertThrows(IllegalStateException.class, () -> singlyLinkedList.getNodeAtIndex(0));
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsGreaterOrEqualToSizeOfList_shouldThrowException() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.getNodeAtIndex(4));
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.getNodeAtIndex(3));
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsNegative_shouldThrowException() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNodeAtIndex(-2));
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsProvided_shouldReturnData() {
        singlyLinkedList.addNode(new ListNode("1"));
        singlyLinkedList.addNode(new ListNode("2"));
        singlyLinkedList.addNode(new ListNode("3"));
        singlyLinkedList.addNode(new ListNode("4"));

        String data = singlyLinkedList.getNodeAtIndex(2).data;
        assertEquals("3", data);

        data = singlyLinkedList.getNodeAtIndex(3).data;
        assertEquals("4", data);
    }

    @Test
    void testAddNode_whenNoIndexProvided_shouldAddAtTheEnd() {
        singlyLinkedList.addNode(new ListNode("1"));
        assertEquals("1", singlyLinkedList.getLastNodeOfList().data);

        singlyLinkedList.addNode(new ListNode("2"));
        assertEquals("2", singlyLinkedList.getLastNodeOfList().data);

        singlyLinkedList.addNode(new ListNode("3"));
        assertEquals("3", singlyLinkedList.getLastNodeOfList().data);
    }

    @Test
    void testAddNode_whenIndexGreaterThanSizeOrNegative_shouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.addNode(new ListNode("1"), 4));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.addNode(new ListNode("1"), -1));
    }

    @Test
    void testAddNode_whenIndexEqualsToSize_listShouldAdd() {
        int size = singlyLinkedList.getSize();
        singlyLinkedList.addNode(new ListNode("1"), size);
        assertEquals("1", singlyLinkedList.getLastNodeOfList().data);

        size = singlyLinkedList.getSize();
        singlyLinkedList.addNode(new ListNode("2"), size);
        assertEquals("2", singlyLinkedList.getLastNodeOfList().data);

        size = singlyLinkedList.getSize();
        singlyLinkedList.addNode(new ListNode("3"), size);
        assertEquals("3", singlyLinkedList.getLastNodeOfList().data);
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
        assertEquals(11, singlyLinkedList.getSize());
    }

    private void checkStringArray(String[] dataArray, int length) {
        IntStream.range(0, length).forEach(index -> {
            assertEquals(index + 1 + "", dataArray[index]);
        });
    }
}
