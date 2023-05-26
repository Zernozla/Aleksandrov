package lab2;

import java.io.*;
import java.util.Scanner;


public class Reader {

    /**
     * Reader - "Считыватель"
     * Метод для построчного считывание данных из файла lab2.txt
     * число передоваемое в метод является строкой, которую метод должен вернуть
     */
    public static String getWord(int pos) throws IOException {
        String word = "";
        int i = 0;
        FileReader read1 = new FileReader("lab2.txt");
        Scanner sc = new Scanner(read1);
/*        while (i != pos) {
            i++;
            sc.nextLine();
            if (i == pos) {
                word = sc.nextLine();
            }
        }
        return word;*/
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
        read1.close();
        return word;
    }
}