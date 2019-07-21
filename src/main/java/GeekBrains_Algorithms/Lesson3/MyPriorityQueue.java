package GeekBrains_Algorithms.Lesson3;

import java.util.Comparator;

public class MyPriorityQueue<T extends Comparable> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 100;
    private Comparator comparator = Comparator.naturalOrder();

    public MyPriorityQueue(int capacity, Comparator comparator) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Comparable[capacity];
            this.comparator = comparator;
        }
    }

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity " + capacity);
        } else {
            list = (T[]) new Comparable[capacity];
            size = 0;
        }
    }

    public MyPriorityQueue() {
        this.list = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void insert(T item){
        if (isFull()) {
            reCapacity(list.length * 2);
        }
        size++;
        list[size] = item;
        int i = size - 1;
        size++;
        //while (i > 0 && list[i].compareTo(list[i - 1]) < 0){
        while (i > 0 && comparator.compare(list[i], list[i - 1]) < 0) {
            swap(i, i - 1);
        }
    }

    public T remove() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else return list[size - 1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArray = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArray, 0, size);
        list = tempArray;
    }

    private void swap (int index1, int index2){
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}
