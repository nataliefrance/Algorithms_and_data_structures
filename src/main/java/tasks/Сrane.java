package tasks;

/*
Задача 92
Петя, Катя и Сережа делают из бумаги журавликов.
Вместе они сделали S журавликов.
Сколько журавликов сделал каждый ребенок, если известно, что Петя и Сережа сделали одинаковое количество журавликов,
а Катя сделала в два раза больше журавликов, чем Петя и Сережа вместе?

Входные данные
В единственной строке входного файла INPUT.TXT записано одно натуральное число S – общее количество сделанных журавликов (S < 10 в 6 степени).
Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести три числа, разделенных пробелами – количество журавликов, которые сделал каждый ребенок (Петя, Катя и Сережа).
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Сrane {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int s = in.nextInt();

        int petya = s / 6;
        int katya = petya * 4;
        int serezha = petya;
        out.print(petya + " " + katya + " " + serezha);
        out.flush();
    }
}
