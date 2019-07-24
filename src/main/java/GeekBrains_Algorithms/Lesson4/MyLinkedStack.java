package GeekBrains_Algorithms.Lesson4;

public class MyLinkedStack<T> {

    private MyDoubleLinkedList<T> myDLL = new MyDoubleLinkedList<>();

    public void push(T value){
        myDLL.insertFirst(value);
    }

    public T pop(){
        return myDLL.removeFirst();
    }

    public T peek(){
        return myDLL.getFirst();
    }

    public int size(){
        return myDLL.size();
    }

    public boolean isEmpty(){
        return myDLL.isEmpty();
    }

}
