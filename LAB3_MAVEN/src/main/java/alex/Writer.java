package alex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writter - "ЗапиССыватель"
 * С помощью этого метода я записываю полученный результат в ходе выполнения задания в файл lab2_1.txt
 * В файл сначала пишется номер выполненного задания, а затем сам ответ
 */
public class Writer
{
    private static final Logger logger = LogManager.getLogger(Writer.class);
    public static void writeCh(String str, int nom) throws IOException {
        logger.debug("Метод writeCh начал выполнение");
        //File file = new File("C:\\Users\\User\\Desktop\\lab2_1.txt");
        //PrintWriter pw = new PrintWriter(file);
        logger.debug("Открытин файла");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lab2_1.txt", true)));
        logger.debug("Запись результата");
        pw.println("Результат задания №" + nom);
        pw.println(str+"\n");
        logger.debug("Закрытие файла");
        pw.close();

    }
}