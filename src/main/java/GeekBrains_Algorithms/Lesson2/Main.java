package GeekBrains_Algorithms.Lesson2;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list_1 = new MyArrayList<Integer>();
//        MyArrayList<Integer> list_2 = new MyArrayList<Integer>();
//        MyArrayList<Integer> list_3 = new MyArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            list_1.add((int) (Math.random() * 10));
//            list_2.add((int) (Math.random()*10));
//            list_3.add((int) (Math.random()*10));
        }

//        long startSelectionSort = System.currentTimeMillis();
//        list_1.selectionSort();
//        System.out.println("Время сортировки выбором: " + (System.currentTimeMillis() - startSelectionSort) + " милисекунд.");
//
//        long startInsertionSort = System.currentTimeMillis();
//        list_2.insertionSort();
//        System.out.println("Время сортировки вставками: " + (System.currentTimeMillis() - startInsertionSort) + " милисекунд.");
//
//        long startBubbleSort = System.currentTimeMillis();
//        list_3.bubbleSort();
//        System.out.println("Время сортировки пузырьком: " + (System.currentTimeMillis() - startBubbleSort) + " милисекунд.");
//
//        MySortedArrayList<Integer> sortedArrayList = new MySortedArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            sortedArrayList.add(i);
//        }
//        System.out.println(sortedArrayList.binaryFind(5));
//        System.out.println(sortedArrayList.binaryFind(101));

        long startQuickSort = System.currentTimeMillis();
        list_1.quickSort();
        System.out.println("Время быстрой сортировки: " + (System.currentTimeMillis() - startQuickSort) + " милисекунд.");

    }
}
