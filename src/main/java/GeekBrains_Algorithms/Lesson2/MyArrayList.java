package GeekBrains_Algorithms.Lesson2;

public class MyArrayList<T extends Comparable> {
    private T[] array;
    private int size;
    private final int DEFAULT_CAPACITY = 1000000;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity: " + capacity);
        } else {
            array = (T[]) new Comparable[capacity];
            size = 0;
        }
    }

    MyArrayList() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += array[i] + " ";
        }
        return s;
    }

    public int getSize() {
        return size;
    }

    //Написать методы удаления, добавления, поиска элемента массива.
    void add(T item) {
        array[size] = item;
        size++;
    }

    void add(int index, T item) {
        if (index > size) {
            size = index;
        }
        if (index < 0) {
            throw new IllegalArgumentException("wrong index: " + index);
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                array[size] = null;
                return true;
            }
        }
        return false;
    }

    boolean find(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    private void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    void selectionSort() {
        int minIndex;
        for (int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = array[i];
            while (j > 0 && key.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
    }

    void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j + 1].compareTo(array[j]) < 0) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public T get(int index) {
        return array[index];
    }

    void qSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        T pivot = array[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (pivot.compareTo(array[j]) < 0) {
                j--;
            }
            if (i <= j){
                swap(i, j);
                i++;
                j--;
            }
        }
        if (low < j){
            qSort(low, j);
        }
        if (high > i){
            qSort(i, high);
        }
    }
    void quickSort(){
        qSort(0, getSize() - 1);
    }
}

