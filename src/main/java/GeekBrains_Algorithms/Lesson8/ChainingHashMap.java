package GeekBrains_Algorithms.Lesson8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashMap<Key, Value> {
    private int capacity = 10; //величина массива
    private int size; //сколько элементов уже добавлено в коллекцию
    private LinkedList<Node>[] st;

    public ChainingHashMap() {
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity; //& - побитовое умножение
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else return true;
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        int i = hash(key);

        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(Key key){
        isKeyNotNull(key);
        int i = hash(key);
        ListIterator<Node> iterator = st[i].listIterator();
        while (iterator.hasNext()){
            if(key.equals(iterator.next().key)){
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                s += node.key.toString() + " ";
            }
            s+="\n";
        }
        s+= "]";
        return s;
    }
}
