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
        addNodesToList(3);
        verifyStringArrayInAscendingOrder(3);
    }

    @Test
    void testSize_whenListIsEmpty_returnZero() {
        assertEquals(0, singlyLinkedList.getSize());
    }

    @Test
    void testSize_whenListHasTwoNodes_returnTwo() {
        addNodesToList(2);
        assertEquals(2, singlyLinkedList.getSize());
    }

    @Test
    void testGetLastNodeOfList_whenListIsEmpty_shouldThrowException() {
        assertThrows(IllegalStateException.class, () -> singlyLinkedList.getLastNodeOfList());
    }

    @Test
    void testGetLastNodeOfList_whenThreeNodes_shouldReturnLastNode() {
        addNodesToList(3);
        assertEquals(3, singlyLinkedList.getLastNodeOfList().data);
    }

    @Test
    void testGetNodeAtIndex_whenListIsEmpty_shouldThrowException() {
        assertThrows(IllegalStateException.class, () -> singlyLinkedList.getNodeAtIndex(0));
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsGreaterOrEqualToSizeOfList_shouldThrowException() {
        addNodesToList(3);
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.getNodeAtIndex(4));
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.getNodeAtIndex(3));
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsNegative_shouldThrowException() {
        addNodesToList(3);
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNodeAtIndex(-2));
    }

    @Test
    void testGetNodeAtIndex_whenIndexIsProvided_shouldReturnData() {
        addNodesToList(4);

        int data = singlyLinkedList.getNodeAtIndex(2).data;
        assertEquals(3, data);

        data = singlyLinkedList.getNodeAtIndex(3).data;
        assertEquals(4, data);
    }

    @Test
    void testGetNodeAtIndexFromEnd_whenIndexIsProvided_shouldReturnData() {
        addNodesToList(6);

        int data = singlyLinkedList.getNodeAtIndexFromEnd(2).data;
        assertEquals(4, data);

        data = singlyLinkedList.getNodeAtIndexFromEnd(3).data;
        assertEquals(3, data);

        data = singlyLinkedList.getNodeAtIndexFromEnd(0).data;
        assertEquals(6, data);

        data = singlyLinkedList.getNodeAtIndexFromEnd(5).data;
        assertEquals(1, data);
    }

    @Test
    void testAddNode_whenNoIndexProvided_shouldAddAtTheEnd() {
        singlyLinkedList.addNode(new ListNode(1));
        assertEquals(1, singlyLinkedList.getLastNodeOfList().data);

        singlyLinkedList.addNode(new ListNode(2));
        assertEquals(2, singlyLinkedList.getLastNodeOfList().data);

        singlyLinkedList.addNode(new ListNode(3));
        assertEquals(3, singlyLinkedList.getLastNodeOfList().data);
    }

    @Test
    void testAddNode_whenIndexGreaterThanSizeOrNegative_shouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.addNode(new ListNode(1), 4));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.addNode(new ListNode(1), -1));
    }

    @Test
    void testAddNode_whenIndexEqualsToSize_listShouldAdd() {
        int size = singlyLinkedList.getSize();
        singlyLinkedList.addNode(new ListNode(1), size);
        assertEquals(1, singlyLinkedList.getLastNodeOfList().data);

        size = singlyLinkedList.getSize();
        singlyLinkedList.addNode(new ListNode(2), size);
        assertEquals(2, singlyLinkedList.getLastNodeOfList().data);

        size = singlyLinkedList.getSize();
        singlyLinkedList.addNode(new ListNode(3), size);
        assertEquals(3, singlyLinkedList.getLastNodeOfList().data);
    }

    @Test
    void testAddNode_whenIndexProvided_listShouldAdd() {
        singlyLinkedList.addNode(new ListNode(1), 0);
        singlyLinkedList.addNode(new ListNode(2), 1);
        singlyLinkedList.addNode(new ListNode(3), 2);
        singlyLinkedList.addNode(new ListNode(5));
        singlyLinkedList.addNode(new ListNode(6));
        singlyLinkedList.addNode(new ListNode(4), 3);
        singlyLinkedList.addNode(new ListNode(7), 6);
        singlyLinkedList.addNode(new ListNode(10));
        singlyLinkedList.addNode(new ListNode(9), 7);
        singlyLinkedList.addNode(new ListNode(8), 7);
        singlyLinkedList.addNode(new ListNode(11), 10);

        assertEquals(11, singlyLinkedList.getSize());
    }

    @Test
    void testDeleteNode_whenListIsEmpty_shouldThrowException() {
        assertThrows(IllegalStateException.class, () -> singlyLinkedList.deleteNode());
        assertEquals(0, singlyLinkedList.getSize());
    }

    @Test
    void testDeleteNode_whenListHasOneNode_shouldDeleteLastNodeAndMakeListEmpty() {
        singlyLinkedList.addNode(new ListNode(1), 0);
        singlyLinkedList.deleteNode();
        assertEquals(0, singlyLinkedList.getSize());
    }

    @Test
    void testDeleteNode_whenListHasMoreThanOneNode_shouldDeleteLastNode() {
        addNodesToList(3);
        singlyLinkedList.deleteNode();
        assertEquals(2, singlyLinkedList.getLastNodeOfList().data);
        assertEquals(2, singlyLinkedList.getSize());
    }

    @Test
    void testDeleteNodeWithIndex_whenIndexIsGreaterOrEqualToSize_shouldThrowException() {
        addNodesToList(3);
        assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.deleteNode(4));
    }

    @Test
    void testDeleteNodeWithIndex_whenIndexIsNegative_shouldThrowException() {
        addNodesToList(3);
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.deleteNode(-4));
    }

    @Test
    void testDeleteNodeWithIndex_whenIndexIsZeroAndListHasOneNode_shouldMakeListEmpty() {
        singlyLinkedList.addNode(new ListNode(1), 0);
        singlyLinkedList.deleteNode(0);
        assertEquals(0, singlyLinkedList.getSize());
    }

    @Test
    void testDeleteNodeWithIndex_whenIndexIsPresentAndListHasThreeNodes_shouldRemoveNode() {
        singlyLinkedList.addNode(new ListNode(1));
        singlyLinkedList.addNode(new ListNode(2));
        singlyLinkedList.addNode(new ListNode(3));
        singlyLinkedList.addNode(new ListNode(9));
        singlyLinkedList.addNode(new ListNode(4));
        singlyLinkedList.addNode(new ListNode(5));
        singlyLinkedList.addNode(new ListNode(6));
        singlyLinkedList.deleteNode(3);
        assertEquals(6, singlyLinkedList.getSize());
        verifyStringArrayInAscendingOrder(6);
    }

    @Test
    void testDeleteNodeWithIndex_whenIndexIsLastAndListHasThreeNodes_shouldRemoveLastNode() {
        addNodesToList(6);
        singlyLinkedList.deleteNode(5);
        assertEquals(5, singlyLinkedList.getSize());
        verifyStringArrayInAscendingOrder(5);
        assertEquals(5, singlyLinkedList.getLastNodeOfList().data);
    }

    @Test
    void testReverse_listShouldBeReversed() {
        singlyLinkedList.addNode(new ListNode(5));
        singlyLinkedList.addNode(new ListNode(4));
        singlyLinkedList.addNode(new ListNode(3));
        singlyLinkedList.addNode(new ListNode(2));
        singlyLinkedList.addNode(new ListNode(1));
        singlyLinkedList.reverse();
        verifyStringArrayInAscendingOrder(5);
    }

    @Test
    void testReverse_whenOnlyOneItem_listShouldBeSame() {
        singlyLinkedList.addNode(new ListNode(1));
        singlyLinkedList.reverse();
        assertEquals(1, singlyLinkedList.getSize());
        assertEquals(1, singlyLinkedList.getLastNodeOfList().data);
    }

    private void verifyStringArrayInAscendingOrder(int length) {
        int[] dataArray = singlyLinkedList.getListOfInts().stream().mapToInt(i -> i).toArray();
        IntStream.range(0, length).forEach(index -> {
            assertEquals(index + 1, dataArray[index]);
        });

        assertEquals(length, dataArray.length);
    }

    private void addNodesToList(int numberOfNodes) {
        IntStream.range(0, numberOfNodes).forEach(index -> {
            singlyLinkedList.addNode(new ListNode(index + 1));
        });
    }
}
