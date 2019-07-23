package GeekBrains_Algorithms.Lesson3;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private int begin;
    private int end;
    private final int DEFAULT_CAPACITY = 100;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
            size = 0;
            begin = 0;
            end = 0;
        }
    }

    public MyDeque() {
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
    }

    public void insertLeft(T item){
        if (isFull()) {
            throw new StackOverflowError("Дек переполнен.");
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }

    public void insertRight(T item){
        if (isFull()) {
            throw new StackOverflowError("Дек переполнен.");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T removeLeft(){
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight(){
        T temp = peekRight();
        size--;
        end = prevIndex(end);
        list[end] = null;
        return temp;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        return (index - 1) >= 0? index - 1 : list.length - 1;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArray = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArray, 0, size);
        list = tempArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    /**
     * @return первый элемент в деке
     */
    public T peekLeft() {
        if (isEmpty()) {
            return null;
        }
        return list[begin];
    }

    /**
     * @return последний элемент в деке
     */
    public T peekRight() {
        if (isEmpty()) {
            return null;
        }
        return list[end - 1];
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
