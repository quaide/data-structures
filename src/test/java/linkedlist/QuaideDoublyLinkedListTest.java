package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

//still need: prepend(), pollFirst(), pollLast(), remove()

public class QuaideDoublyLinkedListTest {

    @Test
    public void addSingleElement() {
        //arrange
        QuaideDoublyLinkedList<String> doublyLinkedList = new QuaideDoublyLinkedList<>();

        //act
        doublyLinkedList.append("Quaide");

        //assert
        Assertions.assertEquals(1, doublyLinkedList.size());
        Assertions.assertEquals("Quaide", doublyLinkedList.peek());
    }

    @Test
    public void addElementToFront() {
        QuaideDoublyLinkedList<String> doublyLinkedList = new QuaideDoublyLinkedList<>();

        doublyLinkedList.prepend("Quaide");
        Assertions.assertEquals("Quaide", doublyLinkedList.peek());

        doublyLinkedList.prepend("Mitch");
        Assertions.assertEquals("Mitch", doublyLinkedList.peek());

        for(int i = 0; i < 20; i++) {
            doublyLinkedList.prepend(String.valueOf(i));
            Assertions.assertEquals(String.valueOf(i), doublyLinkedList.peek());
        }
    }

    @Test
    public void appendingManyElements() {
        QuaideDoublyLinkedList<Integer> doublyLinkedList = new QuaideDoublyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            doublyLinkedList.append(i);
            Assertions.assertEquals(i + 1, doublyLinkedList.size());
            Assertions.assertEquals(i, doublyLinkedList.peekLast());
        }

    }

    @Test
    public void removeElementsFromRear() {
        QuaideDoublyLinkedList<Integer> doublyLinkedList = new QuaideDoublyLinkedList<>();

        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);

        Assertions.assertEquals(3, doublyLinkedList.pollLast());
        Assertions.assertEquals(2, doublyLinkedList.pollLast());
        Assertions.assertEquals(1, doublyLinkedList.size());
        Assertions.assertEquals(1, doublyLinkedList.pollLast());

        Assertions.assertThrows(NoSuchElementException.class, doublyLinkedList::pollLast);
    }
}
