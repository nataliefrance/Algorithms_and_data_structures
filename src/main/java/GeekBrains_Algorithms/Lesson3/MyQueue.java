package GeekBrains_Algorithms.Lesson3;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private int begin;
    private int end;
    private final int DEFAULT_CAPACITY = 100;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
            size = 0;
            begin = 0;
            end = 0;
        }
    }

    public MyQueue() {
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
    }

    public void insert(T item) {
        if (isFull()) {
            reCapacity(list.length * 2);
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    /**
     * @return первый элемент в очереди
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list[begin];
    }

    public T remove() {
        T temp = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
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

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }
}
