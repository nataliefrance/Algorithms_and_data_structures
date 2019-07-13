package tasks;
/*
На свой день рождения Петя купил красивый и вкусный торт, который имел идеально круглую форму.
Петя не знал, сколько гостей придет на его день рождения,
поэтому вынужден был разработать алгоритм, согласно которому он сможет быстро разрезать торт на N равных частей.
Следует учесть, что разрезы торта можно производить как по радиусу, так и по диаметру.

Помогите Пете решить эту задачу, определив наименьшее число разрезов торта по заданному числу гостей.

Входные данные
Входной файл INPUT.TXT содержит натуральное число N – число гостей, включая самого виновника торжества (N ≤ 1000).

Выходные данные
В выходной файл OUTPUT.TXT выведите минимально возможное число разрезов торта.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int guestNumber = in.nextInt();
        int cut = 0;
        if (guestNumber == 1) {
            cut = 0;
        } else if (guestNumber % 2 == 0) {
            cut = guestNumber / 2;
        } else if (guestNumber % 2 != 0) {
            cut = guestNumber;
        }

        out.println(cut);
        out.flush();
    }
}
