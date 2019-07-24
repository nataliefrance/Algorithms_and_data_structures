package GeekBrains_Algorithms.Lesson4;

public class MyLinkedQueue<T> {
    private MyDoubleLinkedList<T> myDLL = new MyDoubleLinkedList<>();

    public void enqueue(T value){
        myDLL.insertFirst(value);
    }

    public T dequeue(){
        return myDLL.removeLast();
    }

    public T peek(){
        return myDLL.getLast();
    }

    public int size(){
        return myDLL.size();
    }

    public boolean isEmpty(){
        return myDLL.isEmpty();
    }
}
