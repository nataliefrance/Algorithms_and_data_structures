package tasks;
/*
№757, Спирт
Каждому школьнику из курса органической химии известна формула молекулы этилового спирта – C2H5(OH).
Откуда видно, что молекула спирта состоит из двух атомов углерода (C), шести атомов водорода (H) и одного атома кислорода (O).

По заданному количеству атомов каждого из описанных выше элементов требуется определить максимально возможное количество молекул спирта,
которые могут образоваться в процессе их соединения.

Входные данные
Первая строка входного файла INPUT.TXT содержит 3 натуральных числа: C, Н и O – количество атомов углерода, водорода и кислорода соответственно. Все числа разделены пробелом и не превосходят 1018.

Выходные данные
В выходной файл OUTPUT.TXT выведите максимально возможное число молекул спирта, которые могут получиться из атомов, представленных во входных данных.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Spirit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long c = in.nextInt();
        long h = in.nextInt();
        long o = in.nextInt();

        long[] spirit = new long[3];
        spirit[0] = c / 2;
        spirit[1] = h / 6;
        spirit[2] = o;

        long min = spirit[0];

        for (int i = 1; i < spirit.length; i++) {
            if (min > spirit[i]){
                min = spirit[i];
            }
        }

        out.println(min);
        out.flush();
    }

}
