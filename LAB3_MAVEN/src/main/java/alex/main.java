package alex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
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
    private static final Logger logger = LogManager.getLogger(main.class);
    public static void main(String[] args) {
        // TODO code application logic here
        tasks lab3_12 = new tasks();
        int n;
        try(Scanner scanner = new Scanner(System.in))
        {
            boolean isQuit = false;
            while (!isQuit)
            {
                //Scanner scanner = new Scanner(System.in);
                logger.debug("Метод main начал выполнение");
                System.out.println("\"Запуск задания: \\n 1 - Посчитать формулу | 2 - Периметр | 3 - Три действительных числа  | 4 - Сравнение a<b<c |\n 5 - Расписание |\" +\n" +
                        "                    \" 6 - Сумма первой и последней цифры | 7 - АМЁБА | 8 - Произведение ряда P | 0 - Выход!\"");
                n = scanner.nextInt();
                logger.debug("Выбор пользователя принят");
                switch (n)
                {
                    case 1:
                        logger.debug("запуск метода task_1 класса tasks");
                        lab3_12.task_1();
                        break;
                    case 2:
                        logger.debug("запуск метода task_2 класса tasks");
                        lab3_12.task_2();
                        break;
                    case 3:
                        logger.debug("запуск метода task_3 класса tasks");
                        lab3_12.task_3();
                        break;
                    case 4:
                        logger.debug("запуск метода task_4 класса tasks");
                        lab3_12.task_4();
                        break;
                    case 5:
                        logger.debug("запуск метода task_5 класса tasks");
                        lab3_12.task_5();
                        break;
                    case 6:
                        logger.debug("запуск метода task_6 класса tasks");
                        lab3_12.task_6();
                        break;
                    case 7:
                        logger.debug("запуск метода task_7 класса tasks");
                        lab3_12.task_7();
                        break;
                    case 8:
                        logger.debug("запуск метода task_8 класса tasks");
                        lab3_12.task_8();
                        break;
                    case 0:
                        isQuit = true;
                        logger.debug("Работа завершена!\n");
                        System.out.print("Работа завершена!\n");
                        break;
                    default:
                        logger.warn("Такого режима нет. Попробуйте " +
                                "выбрать режим заново.");
                        System.out.print("Такого режима нет\n");
                }
            }
        }
        catch (InputMismatchException e)
        {
            logger.fatal("Ошибка " + e + "! " +
                    "Не соответствие типов данных!");
        }
    }
}
