package lab2;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

/**
 * Методы для решения задач
 */

public class tasks {

    /**
     Метод для разделения строки по пробелам и распределения кождого элемента строки в массив
     */
    public static float[] split(String word, int kol){
        float[] variables = new float[kol];
        String[] arrSplit = word.split(" ");
        for (int i=0; i<kol; i++) variables[i] = Float.parseFloat(arrSplit[i]);
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
        System.out.println();
        System.out.println("Задание 1");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        n=in.nextInt();
        switch(n){
            case 1:{

                    System.out.println("Введите a");
                    a= in.nextFloat();
                    System.out.println("Введите b");
                    b =in.nextFloat();
                    System.out.println("Введите c");
                    c = in.nextFloat();

                    res=(b+pow(((pow(b,2))+4*a*c),0.5))/(2*a)-pow(a,3)*c+pow(b,-2);
                    System.out.println("((b+sqrt(b^(2)+4ac))/2a)-a^(3)*c+b^(-2): " + res);
                    System.out.println("Задание 1 завершено\n");
            };break;
            case 2:{
                try {
                    arr1=split(read.getWord(1), 3);
                    System.out.println("a = "+arr1[0] + "; b = " + arr1[1] + "; c = " +arr1[2]);
                    res=(arr1[1]+pow(((pow(arr1[1],2))+4*arr1[0]*arr1[2]),0.5))/(2*arr1[0])-pow(arr1[0],3)*arr1[2]+pow(arr1[1],-2);
                    System.out.println("((b+sqrt(b^(2)+4ac))/2a)-a^(3)*c+b^(-2): " + res);
                    System.out.println("Задание 1 завершено\n");

                    Writter.writeCh("((b+sqrt(b^(2)+4ac))/2a)-a^(3)*c+b^(-2): " + res,1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };break;
            default:
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
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        n=in.nextInt();
        switch(n)
        {
            case 1:
            {
                System.out.println("Введите катет a: ");
                a=in.nextFloat();
                System.out.println("Введите катет b: ");
                b=in.nextFloat();
                c=pow(pow(a,2)+pow(b,2),0.5);
                P=a+b+c;
                S=a*b*0.5;
                System.out.println("Периметр = " +P);
                System.out.println("Площадь = " +S);
                }
                break;
            case 2:
            {
                try { arr=split(read.getWord(2), 2);
                    System.out.println("a = "+arr[0] + "; b = " + arr[1]);
                    c=pow(pow(arr[0],2)+pow(arr[1],2),0.5);
                    P=arr[0]+arr[1]+c;
                    S=arr[0]*arr[1]*0.5;
                    System.out.println("Периметр = " +P);
                    System.out.println("Площадь = " +S);
                    Writter.writeCh("Периметр = " +P+ " Площадь = " +S,2);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
            break;
            default:
                System.out.print("Такого режима нет\n");
        }
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
        System.out.println();
        System.out.println("Задание 3");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        n=in.nextInt();
        switch (n){
            case 1: {
                System.out.println("Введите 3 числа ");
                for(int i=0; i<3;i++)
                {
                    System.out.print("arr["+i+"] = ");
                    arr[i]=in.nextFloat();
                    System.out.println("\n");
                }
                System.out.println(Arrays.toString(arr));
                for(int i=0; i<3;i++){
                    if(arr[i]>0){
                        arr[i]= (float) pow(arr[i],2);
                    }
                    else{
                        arr[i]= (float) pow(arr[i],4);
                    }
                }
                System.out.println(Arrays.toString(arr));

             }
             break;
            case 2:{
                try {
                    arr=split(read.getWord(3),3);
                    System.out.println(Arrays.toString(arr));
                    for(int i=0; i<3;i++){
                        if(arr[i]>0){
                            arr[i]= (float) pow(arr[i],2);
                        }
                        else{
                            arr[i]= (float) pow(arr[i],4);
                        }
                    }
                    System.out.println(Arrays.toString(arr));
                    Writter.writeCh(Arrays.toString(arr),3);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            };break;
            default:
                System.out.print("Такого режима нет\n");
        }
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
        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        k=in.nextInt();
        switch (k)
        {
            case 1:
            {
                    System.out.print("a = ");
                    a=in.nextFloat();
                    System.out.print("b = ");
                    b=in.nextFloat();
                    System.out.print("c = ");
                    c=in.nextFloat();
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
                System.out.println("a = "+a + "b = " +b+ "c = " + c);
            };
            break;
            case 2:
            {
                try {
                    arr=split(read.getWord(4),3);
                    System.out.println("a = "+arr[0] + "b = " +arr[1]+ "c = " + arr[2]);
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
                    Writter.writeCh(Arrays.toString(arr),4);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            };
            break;
            default:
                System.out.print("Такого режима нет\n");
        }
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
        System.out.println("Задание 5");
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        z=in.nextInt();
        switch (z)
        {
            case 1:{
                System.out.println("Введите номер дня недели: ");
                k=in.nextInt();
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
                    }
                    System.out.println("Задание 5 завершено\n");

            };break;
            case 2:{
                try {
                    System.out.println("Введите номер дня недели: ");
                    k=in.nextInt();
                    arr=split(read.getWord(5),7);


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

                    }
                    System.out.println("Задание 5 завершено\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };break;
            default:
                System.out.print("Такого режима нет\n");
        }
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
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        z=in.nextInt();
        switch (z)
        {
            case 1:{
                System.out.println("Введите число: ");
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
                    System.out.println("Сумма первой и последней цифры = " + sum);

                }
                else {
                    System.out.println("Вы ввели не целое число");
                }
                System.out.println("Задание 6 завершено\n");};break;
            case 2:{
                try
                {
                    t= Integer.parseInt(read.getWord(6));
                    System.out.println("Число = "+t);
                    n=t;
                    k=t%10;
                    while(n>9)
                    {
                        n/=10;
                    }
                    sum=k+n;
                    Writter.writeCh("Сумма первой и последней цифры = " + sum,6);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Задание 6 завершено\n");
            }break;
            default:
                System.out.print("Такого режима нет\n");
        }
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
        System.out.println("Вы хотите вывести данные в консоль(1) или в файла(2)?");
        z = in.nextInt();

        switch (z) {

            case 1: {
                while (k < 24) {
                    a *= 2;
                    k += 3;
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
                        Writter.writeCh("Через " + k + " часов будет " + a + " амеб", 7);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Задание 7 завершено\n");
            }
            default:{
                System.out.print("Такого режима нет\n");
            }
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
        int n,z,k=1;
        double P=1;
        System.out.println("Вы хотите ввести данные с консоли(1) или с файла(2)?");
        z=in.nextInt();
        switch (z){
            case 1:{
                System.out.println("Введите n для P = (2/3)*(4/5)*...*(2n/2n+1) n = " );
                n=in.nextInt();
                for(int i=1; i<=n;i++)
                {
                    P=P*(2*i)/(2*i+1);
                    System.out.println(P);
                }
                System.out.println("Произведение ряда P = "+P);
                System.out.println("Задание 8 завершено\n");
            };break;
            case 2:{
                try {
                    n=Integer.parseInt(read.getWord(7));
                    for(int i=1; i<=n;i++)
                    {
                        P=P*(2*i)/(2*i+1);

                    }
                    Writter.writeCh("Произведение ряда P = "+P,8);

                    } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Задание 8 завершено\n");
                }break;
            default:
                System.out.print("Такого режима нет\n");
        }
    }
}
