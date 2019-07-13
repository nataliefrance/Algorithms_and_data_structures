package tasks;
/*
Маша и Миша собирали землянику. Маше удалось сорвать X ягод, а Мише – Y ягод.
 Поскольку ягода была очень вкусной, то ребята могли какую то часть ягод съесть.
 По нашим подсчетам вместе они съели Z ягод.

Требуется определить: сколько ягод ребята собрали в результате, при этом следует проверить,
 не ошиблись ли мы в расчетах, подсчитывая количество съеденных ягод
 (их не должно было получиться больше, чем сорванных ягод).
*/

/*
Входные данные
Входной файл INPUT.TXT содержит три натуральных числа X, Y и Z, не превышающих 1000. Все числа расположены в первой строке файла и разделены пробелом.

Выходные данные
В выходной файл OUTPUT.TXT выведите количество собранных ягод, если наши подсчеты оказались правдоподобными, либо слово «Impossible» в противном случае.
 */
import java.io.*;

public class Sbor_zemlyaniki {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("src\\main\\resources\\INPUT.TXT");
        File outputFile = new File("src\\main\\resources\\OUTPUT.TXT");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;

        while ((line = reader.readLine()) != null) {
            int[] array_of_XYZ = stringToIntArray(line);
            if (collectedBerries(array_of_XYZ) >= 0){
                writer.write(collectedBerries(array_of_XYZ));
                writer.newLine();
            } else {
                writer.write("Impossible");
                writer.newLine();
            }
        }

        reader.close();
        writer.close();

    }

    private static int[] stringToIntArray(String line){
        String[] stringArray = line.split(" ");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }

    private static int collectedBerries(int[] array){
        return array[0] + array[1] - array[2];
    }


}
