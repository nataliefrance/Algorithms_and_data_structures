package GeekBrains_Algorithms.Lesson4;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
//        myLinkedList.insertFirst("GO!!!");
//        myLinkedList.insertFirst("one");
//        myLinkedList.insertFirst("two");
//        myLinkedList.insertFirst("three");
//
//        System.out.println(myLinkedList.getFirst());
//        myLinkedList.remove("two");
//        System.out.println(myLinkedList);
//        myLinkedList.insert(1, "two");
//        System.out.println(myLinkedList);

        MyDoubleLinkedList<String> myDLL = new MyDoubleLinkedList<>();
        myDLL.insertFirst("one");
        myDLL.insertFirst("two");
        myDLL.insertFirst("three");
        myDLL.insertFirst("four");
        myDLL.insertLast("GO!!!");
        myDLL.insert(99, "99");
        System.out.println(myDLL);
        myDLL.removeLast();
        System.out.println(myDLL);

        Iterator<String> iterator = myDLL.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.print(s + ", ");
            if (s.equals("one")){
                iterator.remove();
            }
        }
        System.out.println();
        System.out.println(myDLL);
    }
}
