package GeekBrains_Algorithms.Lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        BST <Integer, String> bst = new BST<>();
//        bst.put(3, "three");
//        bst.put(2, "two");
//        bst.put(4, "four");
//        bst.put(1, "one");
//        bst.put(5, "five");
//        System.out.println(bst.isBalanced());

        BST<Integer, String>[] bstArray = new BST[20];
        int min = -100; // Минимальное число для диапазона
        int max = 100; // Максимальное число для диапазона

        for (int i = 0; i < bstArray.length; i++) {
            bstArray[i] = new BST<>("tree_" + i);
            while (bstArray[i].depth() != 6) {
                int random = (int) (Math.random() * ++max) + min;
                bstArray[i].put(random, String.valueOf(random));
            }
        }

        int balancedTrees = 0;
        for (BST<Integer, String> integerStringBST : bstArray) {
            if (integerStringBST.isBalanced()) {
                balancedTrees++;
            }
        }

        System.out.println((balancedTrees / bstArray.length ) * 100 + "% сбалансированных деревьев.");

//        System.out.println(bstArray[0]);
//        System.out.println(bstArray[0].depth());
//        System.out.println(bstArray[1]);
//        System.out.println(bstArray[1].depth());
    }
}
