package GeekBrains_Algorithms.Lesson3;

public class MyStack<T> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 100;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
            size = 0;
        }
    }

    public MyStack() {
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
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

    public T peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else return list[size - 1];
    }

    public void push(T item) {
        if (isFull()) {
            reCapacity(list.length * 2);
        }
        list[size] = item;
        size++;
    }

    /**
     * @return удаляет и возращает верхний элемент из стека
     */
    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
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
            s += list[i] + "";
        }
        return s;
    }
}
