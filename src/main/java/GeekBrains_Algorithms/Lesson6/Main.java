package GeekBrains_Algorithms.Lesson6;

public class Main {
    public static void main(String[] args) {
        BST <Integer, String> bst = new BST<>();
        bst.put(5, "five");
        bst.put(4, "four");
        bst.put(3, "three");
        bst.put(2, "two");
        bst.put(1, "one");

        System.out.println(bst);
        System.out.println(bst.minKey());
        System.out.println(bst.maxKey());
        bst.deleteMin();
        System.out.println(bst);
    }
}
