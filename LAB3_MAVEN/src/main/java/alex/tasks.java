package alex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * Методы для решения задач
 */

public class tasks {

    /**
     Метод для разделения строки по пробелам и распределения кождого элемента строки в массив
     */
    private static final Logger logger = LogManager.getLogger(tasks.class);
    public static float[] split(String word, int kol){
        logger.debug("Метод split начал выполнение");
        float[] variables = new float[kol];
        String[] arrSplit = word.split(" ");
        logger.debug("Рассчет массива");
        for (int i=0; i<kol; i++) variables[i] = Float.parseFloat(arrSplit[i]);
        logger.debug("Метод split закончил выполнение");
        return variables;
    }
    /**
     * Первое задание
     * Нужно посчитать значение формулы
     * С помощью оператор "pow" были решены случаи с возведением в степень и корнем
     */
    public static void task_1(){
        Reader read = new Reader();
        float[] arr1 = new float[3];
        Scanner in = new Scanner(System.in);
        int n;
        float a,b,c;
        double res;
        logger.debug("Метод task_1 начал выполнение");
        System.out.println();
        System.out.println("Задание 1");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        logger.debug("Выбор пользователя принят");
        n=in.nextInt();
        switch(n){
            case 1:{
                logger.debug("Ввод с клавиатуры чисел");
                System.out.println("Введите a");
                a= in.nextFloat();
                System.out.println("Введите b");
                b =in.nextFloat();
                System.out.println("Введите c");
                c = in.nextFloat();
                logger.debug("Числа получены");
                logger.debug("Вычисление результата");
                res=(b+pow(((pow(b,2))+4*a*c),0.5))/(2*a)-pow(a,3)*c+pow(b,-2);
                logger.debug("Вывод результата");
                System.out.println("((b+sqrt(b^(2)+4ac))/2a)-a^(3)*c+b^(-2): " + res);
                System.out.println("Задание 1 завершено\n");
                logger.debug("Метод task_1 закончил выполнение");
            };break;
            case 2:{
                try {
                    logger.debug("Чтение чисел из файла");
                    arr1=split(read.getWord(1), 3);
                    logger.debug("Числа получены");
                    System.out.println("a = "+arr1[0] + "; b = " + arr1[1] + "; c = " +arr1[2]);
                    logger.debug("Вычисление результата");
                    res=(arr1[1]+pow(((pow(arr1[1],2))+4*arr1[0]*arr1[2]),0.5))/(2*arr1[0])-pow(arr1[0],3)*arr1[2]+pow(arr1[1],-2);
                    logger.debug("Вывод результата в консоль");
                    System.out.println("((b+sqrt(b^(2)+4ac))/2a)-a^(3)*c+b^(-2): " + res);
                    System.out.println("Задание 1 завершено\n");
                    logger.debug("Вывод результата в файл");
                    Writer.writeCh("((b+sqrt(b^(2)+4ac))/2a)-a^(3)*c+b^(-2): " + res,1);
                    logger.debug("Метод task_1 закончил выполнение");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };break;
            default:
                logger.warn("Такого режима нет. Попробуйте " +
                        "выбрать режим заново.");
                System.out.print("Такого режима нет\n");

        }
    }
    /**
     Задание 2
     Нужно найти площадь и периметр треугольника по катетам "а" и "b"
     Применялись формулы для получения P и S изученные еще в школе
     */
    public static void task_2(){
        Reader read = new Reader();
        Scanner in = new Scanner(System.in);
        int n;
        double a,b,c,S,P;
        float[] arr = new float[2];
        logger.debug("Метод task_2 начал выполнение");
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        n=in.nextInt();
        logger.debug("Выбор пользователя принят");
        switch(n)
        {
            case 1:
            {
                logger.debug("Ввод катетов с клавиатуры");
                System.out.println("Введите катет a: ");
                a=in.nextFloat();
                System.out.println("Введите катет b: ");
                b=in.nextFloat();
                logger.debug("Значения получены");
                logger.debug("Вычисление результата");
                c=pow(pow(a,2)+pow(b,2),0.5);
                P=a+b+c;
                S=a*b*0.5;
                logger.debug("Вывод результата в консоль");
                System.out.println("Периметр = " +P);
                System.out.println("Площадь = " +S);
            }
            break;
            case 2:
            {
                try {
                    logger.debug("Чтение катетов из файла");
                    arr=split(read.getWord(2), 2);
                    logger.debug("Значения получены");
                    System.out.println("a = "+arr[0] + "; b = " + arr[1]);
                    logger.debug("Вычисление результата");
                    c=pow(pow(arr[0],2)+pow(arr[1],2),0.5);
                    P=arr[0]+arr[1]+c;
                    S=arr[0]*arr[1]*0.5;
                    logger.debug("Вывод результата в консоль и файл");
                    System.out.println("Периметр = " +P);
                    System.out.println("Площадь = " +S);
                    Writer.writeCh("Периметр = " +P+ " Площадь = " +S,2);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
            break;
            default:
                logger.warn("Такого режима нет. Попробуйте" +
                        " выбрать режим заново.");
                System.out.print("Такого режима нет\n");

        }
        logger.debug("Метод task_2 закончил выполнение");
    }
    /**
     Задание 3
     Нужно возвести в 4ю степень неотрицательные значения, а отрицательные во вторую
     Проводилась проверка на отрицательность и с помощью ветвления достигался требуемый результат
     */
    public static void task_3()  {
        int n;
        float[] arr = new float[3];
        Reader read = new Reader();
        Scanner in = new Scanner(System.in);
        logger.debug("Метод task_3 начал выполнение");
        System.out.println();
        System.out.println("Задание 3");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        n=in.nextInt();
        logger.debug("Выбор пользователя принят");
        switch (n){
            case 1: {
                logger.debug("Ввод чисел с клавиатуры");
                System.out.println("Введите 3 числа ");
                for(int i=0; i<3;i++)
                {
                    System.out.print("arr["+i+"] = ");
                    arr[i]=in.nextFloat();
                    System.out.println("\n");
                }
                logger.debug("Числа получены");
                System.out.println(Arrays.toString(arr));
                logger.debug("Вычисдение результата");
                for(int i=0; i<3;i++){
                    if(arr[i]>0){
                        arr[i]= (float) pow(arr[i],2);
                    }
                    else{
                        arr[i]= (float) pow(arr[i],4);
                    }
                }
                logger.debug("Вывод результата в консоль");
                System.out.println(Arrays.toString(arr));

            }
            break;
            case 2:{
                try {
                    logger.debug("Чтение числе из файла");
                    arr=split(read.getWord(3),3);
                    logger.debug("Числа получены");
                    System.out.println(Arrays.toString(arr));
                    logger.debug("Вычисление результата");
                    for(int i=0; i<3;i++){
                        if(arr[i]>0){
                            arr[i]= (float) pow(arr[i],2);
                        }
                        else{
                            arr[i]= (float) pow(arr[i],4);
                        }
                    }
                    logger.debug("Вывод результата в консоль и файл");
                    System.out.println(Arrays.toString(arr));
                    Writer.writeCh(Arrays.toString(arr),3);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            };break;
            default:
                logger.warn("Такого режима нет. Попробуйте" +
                        " выбрать режим заново.");
                System.out.print("Такого режима нет\n");

        }
        logger.debug("Метод task_3 закончил выполнение");
    }
    /**
     * Задание 4
     * Нужно удвоить "a", "b", "c" если справедливо a<b<c, иначе найти их модуль
     * Модуль - оператор abs
     */
    public static void task_4(){
        Reader read = new Reader();
        float a,b,c;
        float[] arr = new float[3];
        int k, n=0;
        Scanner in = new Scanner(System.in);
        logger.debug("Метод task_3 начал выполнение");
        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        k=in.nextInt();
        logger.debug("Выбор пользователя принят");
        switch (k)
        {
            case 1:
            {
                logger.debug("Вывод числе с клавиатуры");
                System.out.print("a = ");
                a=in.nextFloat();
                System.out.print("b = ");
                b=in.nextFloat();
                System.out.print("c = ");
                c=in.nextFloat();
                logger.debug("Значения получены");
                logger.debug("Вычисление результата");
                if(b>a && c>b)
                {

                    a*=2;
                    b*=2;
                    c*=2;
                }
                else {
                    a=abs(a);
                    b=abs(b);
                    c=abs(c);
                }
                logger.debug("Вывод результата в консоль");
                System.out.println("a = "+a + "b = " +b+ "c = " + c);
            };
            break;
            case 2:
            {
                try {
                    logger.debug("Чтение значений из файла");
                    arr=split(read.getWord(4),3);
                    logger.debug("Значения получены");
                    System.out.println("a = "+arr[0] + "b = " +arr[1]+ "c = " + arr[2]);
                    logger.debug("Вычисление результата");
                    if(arr[1]>arr[0] && arr[3]>arr[2])
                    {

                        arr[0]*=2;
                        arr[1]*=2;
                        arr[2]*=2;
                    }
                    else {
                        arr[0]=abs(arr[0]);
                        arr[1]=abs(arr[1]);
                        arr[2]=abs(arr[2]);
                    }
                    logger.debug("Вывод результата в файл");
                    Writer.writeCh(Arrays.toString(arr),4);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            };
            break;
            default: {
                logger.warn("Такого режима нет. Попробуйте" + " выбрать режим заново.");
                System.out.print("Такого режима нет\n");
            }
        }
        logger.debug("Метод task_4 закончил выполнение");
    }
    /**
     * Задание 5
     * Нужно реализовать меню (switch) с возможность ввода номера дня недели и получить на выходе количество занятий в этот день
     * Применялся switch для достижения поставленного результата
     */
    public static void task_5(){
        int k, n, z;
        Reader read = new Reader();
        float[] arr = new float[7];
        Scanner in = new Scanner(System.in);
        logger.debug("Метод task_4 начал выполнение");
        System.out.println("Задание 5");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        z=in.nextInt();
        logger.debug("Выбор пользователя принят");
        switch (z)
        {
            case 1:{
                logger.debug("Ввод номера дня недели");
                System.out.println("Введите номер дня недели: ");
                k=in.nextInt();
                logger.debug("Номер получен");
                logger.debug("Вывод результата");
                switch (k)
                {
                    case 1:
                        System.out.println("В понедельник "+4+" пары");
                        break;
                    case 2:
                        System.out.println("Во вторник "+4+" пары");
                        break;
                    case 3:
                        System.out.println("В среду "+2+" пары");
                        break;
                    case 4:
                        System.out.println("В четверг "+3+" пары");
                        break;
                    case 5:
                        System.out.println("В пятницу нет пар");
                        break;
                    case 6:
                        System.out.println("В субботу "+2+" пары");
                        break;
                    case 7:
                        System.out.println("В воскресенье "+10+" пар!!");
                        break;
                    default:
                        System.out.print("НЕ НОМЕР ДНЯ НЕДЕЛИ\n");
                        logger.warn("Такого дня недели нет");
                }
                System.out.println("Задание 5 завершено\n");

            };break;
            case 2:{
                try {
                    logger.debug("Ввод номера дня недели");
                    System.out.println("Введите номер дня недели: ");
                    k=in.nextInt();
                    arr=split(read.getWord(5),7);
                    logger.debug("Номер получен");
                    logger.debug("Вывод результата на основе файла");
                    switch (k)
                    {
                        case 1:
                            System.out.println("В понедельник "+arr[0]+" пары");
                            break;
                        case 2:
                            System.out.println("Во вторник "+arr[1]+" пары");
                            break;
                        case 3:
                            System.out.println("В среду "+arr[2]+" пары");
                            break;
                        case 4:
                            System.out.println("В четверг "+arr[3]+" пары");
                            break;
                        case 5:
                            System.out.println("В пятницу "+arr[4]+" пар");
                            break;
                        case 6:
                            System.out.println("В субботу "+arr[5]+" пары");
                            break;
                        case 7:
                            System.out.println("В воскресенье "+arr[6]+" пар!!");
                            break;
                        default:
                            System.out.print("НЕ НОМЕР ДНЯ НЕДЕЛИ\n");
                            logger.warn("Такого дня недели нет");

                    }
                    System.out.println("Задание 5 завершено\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };break;
            default:
                logger.warn("Такого режима нет. Попробуйте" +
                        " выбрать режим заново.");
                System.out.print("Такого режима нет\n");

        }
        logger.debug("Метод task_5 закончил выполнение");
    }
    /**
     * Задание 6
     * Нужно найти сумму первой и последней цифры в числе
     * Последняя цифра находится с помощью деления с нахождением остатка (%)
     * Первая цифра с помощью деления без остатка на 10 исходного числа до тех пор, пока оно больше 9
     */
    public static void task_6(){
        Reader read = new Reader();
        System.out.println();
        System.out.println("Задание 6");
        int z, t,k,n,sum;
        Scanner in = new Scanner(System.in);
        logger.debug("Метод task_6 начал выполнение");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        z=in.nextInt();
        logger.debug("Ответ пользователя принят");
        switch (z)
        {
            case 1:{
                logger.debug("Ввод числа с клавиатуры");
                System.out.println("Введите число: ");
                logger.debug("Вычисление результата");
                if(in.hasNextInt()) {
                    t=in.nextInt();
                    System.out.println("Число = "+t);
                    n=t;
                    k=t%10;
                    while(n>9)
                    {
                        n/=10;
                    }
                    sum=k+n;
                    logger.debug("Вывод результатат в консоль");
                    System.out.println("Сумма первой и последней цифры = " + sum);

                }
                else {
                    System.out.println("Вы ввели не целое число");
                    logger.warn("Вы ввели не целов число");
                }
                System.out.println("Задание 6 завершено\n");};break;
            case 2:{
                try
                {
                    logger.debug("Чтение числа с файла");
                    t= Integer.parseInt(read.getWord(6));
                    System.out.println("Число = "+t);
                    n=t;
                    k=t%10;
                    while(n>9)
                    {
                        n/=10;
                    }
                    sum=k+n;
                    Writer.writeCh("Сумма первой и последней цифры = " + sum,6);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Задание 6 завершено\n");
            }break;
            default:
                logger.warn("Такого режима нет. Попробуйте" +
                        " выбрать режим заново.");
                System.out.print("Такого режима нет\n");

        }
        logger.debug("Метод task_6 закончил выполнение");
    }
    /**
     Задание 7
     Нужно написать алгоритм нахождения числа амеб через 3,6,9..24 часа
     Просто идваивал и выводил кол-во амеб каждые три часа пока не пройдет 24 часа
     */

    public static void task_7()  {
        System.out.println("Задание 7");
        Scanner in = new Scanner(System.in);
        int a = 1, k = 0, z;
        logger.debug("Метод task_7 начал выполнение");
        System.out.println("Вы хотите вывести данные в консоль(1) или в файла(2)?");
        z = in.nextInt();
        logger.debug("Выбор пользователя принят");
        logger.debug("Вычисление результата");
        switch (z) {

            case 1: {
                while (k < 24) {
                    a *= 2;
                    k += 3;
                    logger.debug("Вывод результата в консоль");
                    System.out.println("Через " + k + " часов будет " + a + " амеб");
                }

                System.out.println("Задание 7 завершено\n");
            }

            break;
            case 2: {
                try {
                    while (k < 24) {
                        a *= 2;
                        k += 3;
                        logger.debug("Вывод результата в файл");
                        Writer.writeCh("Через " + k + " часов будет " + a + " амеб", 7);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Задание 7 завершено\n");
                logger.debug("Метод task_7 закончил выполнение");
            }
            default:{
                logger.warn("Такого режима нет. Попробуйте" +
                        " выбрать режим заново.");
                System.out.print("Такого режима нет\n");

            }
            logger.debug("Метод task_7 закончил выполнение");
        }

    }


    /**
     * Задание 8
     * Нужно найти значения ряда "P" при введеной "n"
     * Цикл с параметром
     */
    public static void task_8(){
        System.out.println("Задание 8");
        Reader read = new Reader();
        Scanner in = new Scanner(System.in);
        logger.debug("Метод task_8 начал выполнение");
        int n,z,k=1;
        double P=1;
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        z=in.nextInt();
        logger.debug("Выбор пользователя принят");
        switch (z){
            case 1:{
                logger.debug("Ввод значения с клавиатуры");
                System.out.println("Введите n для P = (2/3)*(4/5)*...*(2n/2n+1) n = " );
                n=in.nextInt();
                logger.debug("Значение полученр");
                logger.debug("Вычисление результата");
                for(int i=1; i<=n;i++)
                {
                    P=P*(2*i)/(2*i+1);
                    //System.out.println(P);
                }
                logger.debug("Вывод результата");
                System.out.println("Произведение ряда P = "+P);
                System.out.println("Задание 8 завершено\n");
            };break;
            case 2:{
                try {
                    logger.debug("Чтение значения из файла");
                    n=Integer.parseInt(read.getWord(7));
                    logger.debug("Значение получено");
                    logger.debug("Вычисление результата");
                    for(int i=1; i<=n;i++)
                    {
                        P=P*(2*i)/(2*i+1);

                    }
                    logger.debug("Вывод результата в файл");
                    Writer.writeCh("Произведение ряда P = "+P,8);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Задание 8 завершено\n");
            }break;
            default:
                logger.warn("Такого режима нет. Попробуйте" +
                        " выбрать режим заново.");
                System.out.print("Такого режима нет\n");

        }
        logger.debug("Метод task_8 закончил выполнение");
    }
}
