package alex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Reader {

    /**
     * Reader - "Считыватель"
     * Метод для построчного считывание данных из файла lab2.txt
     * число передоваемое в метод является строкой, которую метод должен вернуть
     */
    private static final Logger logger = LogManager.getLogger(Reader.class);
    public static String getWord(int pos) throws IOException {
        logger.debug("Метод getWord начал выполнение");
        String word = "";
        int i = 0;
        FileReader read1 = new FileReader("lab3.txt");
        Scanner sc = new Scanner(read1);
/*        while (i != pos) {
            i++;
            sc.nextLine();
            if (i == pos) {
                word = sc.nextLine();
            }
        }
        return word;*/
        logger.debug("Чтение файла");
        while (sc.hasNextLine() && i!=pos) {
            i++;
            if(i==pos) {

                word += sc.nextLine();
                break;
            }
            else{
                sc.nextLine();
            }

        }
        logger.debug("Закрытие файла");
        read1.close();
        logger.debug("Метод getWord закончил выполнение");
        return word;
    }
}
