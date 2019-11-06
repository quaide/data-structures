package linkedlist;

import java.util.NoSuchElementException;

public class QuaideDoublyLinkedList<T> {

    private int size;
    private QuaideNode<T> head;
    private QuaideNode<T> tail;

    public QuaideDoublyLinkedList() {
        this.size = 0;
    }

    public void append(T value) {
        if (head == null) {
            head = new QuaideNode<>(null, null, value);
        } else if (tail == null) {
            tail = new QuaideNode<>(null, head, value);
            head.setNextInLine(tail);
        } else {
            QuaideNode<T> newTail = new QuaideNode<>(null, tail, value);
            tail.setNextInLine(newTail);
            tail = newTail;
        }
        size++;
    }

    public void prepend(T value) {
        if (head == null) {
            head = new QuaideNode<>(null, null, value);
        } else if (tail == null) {
            tail = head;
            head = new QuaideNode<>(tail, null, value);
        } else {
            QuaideNode<T> newHead = new QuaideNode<>(head, null, value);
            head.setInFrontOfMe(newHead);
            head = newHead;
        }
        size++;
    }

    public T pollLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T returnValue;
        if (size == 1) {
            returnValue = head.getValue();
            head = null;
        } else if (size == 2) {
            returnValue = tail.getValue();
            tail = null;
        } else {
            System.out.println(tail.toString());

            returnValue = tail.getValue();
            tail = tail.getInFrontOfMe();
        }
        size = size - 1;
        return returnValue;
    }

    public T pollFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T returnValue;
        if (size == 1) {
            returnValue = head.getValue();
            head = null;
        } else {
            returnValue = head.getValue();
            head = head.getNextInLine();
        }
        size = size - 1;
        return returnValue;
    }

    public boolean remove(T element) {
        if (size == 1 && head.getValue().equals(element)) {
            head = null;
            size = size - 1;
            return true;
        } else if (size > 1) {
            for (QuaideNode<T> current = head; current != tail; current = current.getNextInLine()) {
                if (current.getValue().equals(element)) {
                    removeFromList(current);
                    return true;
                }
            }
            if (tail.getValue().equals(element)) {
                removeTail();
                return true;
            }
        }
        return false;
    }

    private void removeTail() {
        tail = tail.getInFrontOfMe();
        tail.setNextInLine(null);
        size = size - 1;
    }

    private void removeFromList(QuaideNode<T> current) {
        QuaideNode<T> inFrontOfMe = current.getInFrontOfMe();
        QuaideNode<T> nextInLine = current.getNextInLine();
        inFrontOfMe.setNextInLine(nextInLine);
        nextInLine.setInFrontOfMe(inFrontOfMe);
        size = size - 1;
    }

    public T peek() {
        return head.getValue();
    }

    public int size() {
        return size;
    }

    public T peekLast() {
        if (tail == null) {
            return head.getValue();
        }
        return tail.getValue();
    }
}
