package lab2;
import java.util.Scanner;

/**
 * @author <strong>Александров Александр</strong>
 * @version 0.0.7
 * @since 0.0.1
 */

public class main {

    /**
     * Это меню для выбора интересующего нас задания
     */

    public static void main(String[] args) {
        // TODO code application logic here
        tasks lab2 = new tasks();
        boolean isQuit = false;
        while (!isQuit) {
            int n;
            System.out.println("Запуск задания: \n 1 - Посчитать формулу | 2 - Периметр | 3 - Три действительных числа  | 4 - Сравнение a<b<c |\n 5 - Расписание |" +
                    " 6 - Сумма первой и последней цифры | 7 - АМЁБА | 8 - Произведение ряда P | 0 - Выход!");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            switch (n) {
                case 1:
                    lab2.task_1();
                    break;
                case 2:
                    lab2.task_2();
                    break;
                case 3:
                    lab2.task_3();
                    break;
                case 4:
                    lab2.task_4();
                    break;
                case 5:
                    lab2.task_5();
                    break;
                case 6:
                    lab2.task_6();
                    break;
                case 7:
                    lab2.task_7();
                    break;
                case 8:
                    lab2.task_8();
                    break;
                case 0:
                    isQuit = true;
                    System.out.print("Работа завершена!");
                    break;
                default:
                    System.out.print("Такого режима нет");
            }
        }
    }
}
