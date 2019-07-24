package GeekBrains_Algorithms.Lesson4;

public class MyLinkedList<T> {

    private Node first;
    private int size;

    public MyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    class Node<T> {
        private T value;
        private Node next;


        public Node(T value) {
            this.value = value;
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
        return (T) first.getValue();
    }

    public void insertFirst(T item) {
        Node newNode = new Node<T>(item);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        size--;
        return (T) oldFirst.getValue();
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
        if (index > size) {
            index = size;
        }
        Node current = first;
        int currentIndex = 0;

        while (currentIndex < index - 1) {
            current = current.getNext();
            currentIndex++;
        }

        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public boolean remove(T item){
        if(isEmpty()){
            return false;
        }
        if(item.equals(first.getValue())){
            removeFirst();
            return true;
        }
        Node current = first;

        while(current.getNext() != null && !item.equals(current.getNext().getValue())){
            current = current.getNext();
        }

        if (current.getNext() == null){
            return false;
        }

        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder s = new StringBuilder();
        while (current != null){
            s.append(current.getValue() + " ");
            current = current.getNext();
        }
        return s.toString();
    }
}
