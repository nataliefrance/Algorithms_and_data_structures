package GeekBrains_Algorithms.Lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //System.out.println(factorial(5));
        //System.out.println(exponentiation(2, 3));

        //Задача о рюкзаке

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Косметичка", 80, 1000));
        items.add(new Item("Ноутбук", 100, 1100));
        items.add(new Item("Перекус", 50, 550));
        items.add(new Item("Аптечка", 50, 550));
        items.add(new Item("Блокнот", 50, 550));
        items.add(new Item("Книга", 50, 550));


        Backpack backpack = new Backpack(100);
        backpack.makeAllSets(items);
        ArrayList<Item> solution = backpack.getBestSet();

        if (solution == null) {
            System.out.println("Нет решения!");
        } else {
            System.out.println("Берём с собой:");
            for (int i = 0; i < solution.size(); i++) {
                System.out.println(solution.get(i).name);
            }
        }
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    private static long fibo(int n) {
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    private static long recFibo(long n) {
        System.out.print(n + " ");
        if (n < 3) {
            return 1;
        }
        return recFibo(n - 1) + recFibo(n - 2);
    }

    private static int triangleNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static int recTriangleNum(int n) {
        if (n == 1) {
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }

    private static int multiply(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        return value;
    }

    private static int recMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }

    private static int exponentiation(int number, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return number;
        }
        return exponentiation(number, exponent - 1) * number;
    }
}
