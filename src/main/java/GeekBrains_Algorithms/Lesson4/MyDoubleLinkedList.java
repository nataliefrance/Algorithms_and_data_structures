package GeekBrains_Algorithms.Lesson4;

import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T>{

    private Node first;
    private Node last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T>{
        Node current = new Node(null, first, null);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            return current.getValue();
        }

        @Override
        public void remove() {
            if (current == first) {
                removeFirst();
            } else if (current == last) {
                removeLast();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        }
    }

    private class Node {
        private T value;
        private Node next;
        private Node previous;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node(Node next) {
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (!isEmpty()) {
            first.setPrevious(newNode);
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (!isEmpty()) {
            newNode.setPrevious(last);
            last.setNext(newNode);
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrevious(null);
        }
        size--;
        return (T) oldFirst.getValue();
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = last;
        if (last.getPrevious() != null) {
            last.getPrevious().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrevious();
        size--;
        return (T) oldLast.getValue();
    }

    public int indexOf(T item) {
        Node current = first;
        int index = 0;

        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        if (index >= size) {
            insertLast(item);
            return;
        }
        Node current = first;
        int currentIndex = 0;

        while (currentIndex < index - 1) {
            current = current.getNext();
            currentIndex++;
        }

        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        newNode.getNext().setPrevious(newNode);

        current.setNext(newNode);
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (item.equals(first.getValue())) {
            removeFirst();
            return true;
        }
        Node current = first;

        while (current != null && !item.equals(current.getValue())) {
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (current == last) {
            removeLast();
            return true;
        }

        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.getValue() + " ");
            current = current.getNext();
        }
        return s.toString();
    }
}
