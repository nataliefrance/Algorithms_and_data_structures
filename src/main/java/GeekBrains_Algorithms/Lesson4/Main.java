package GeekBrains_Algorithms.Lesson4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.insertFirst("GO!!!");
        myLinkedList.insertFirst("one");
        myLinkedList.insertFirst("two");
        myLinkedList.insertFirst("three");

        System.out.println(myLinkedList.getFirst());
        myLinkedList.remove("two");
        System.out.println(myLinkedList);
        myLinkedList.insert(1, "two");
        System.out.println(myLinkedList);
    }
}
