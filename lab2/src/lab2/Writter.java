package lab2;

import java.io.*;

/**
 * Writter - "ЗапиССыватель"
 * С помощью этого метода я записываю полученный результат в ходе выполнения задания в файл lab2_1.txt
 * В файл сначала пишется номер выполненного задания, а затем сам ответ
 */
public class Writter
{
    public static void writeCh(String str, int nom) throws IOException {
        //File file = new File("C:\\Users\\User\\Desktop\\lab2_1.txt");
        //PrintWriter pw = new PrintWriter(file);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lab2_1.txt", true)));
        pw.println("Результат задания №" + nom);
        pw.println(str+"\n");
        pw.close();

    }
}