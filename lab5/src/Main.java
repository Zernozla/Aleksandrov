import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Программа для лабораторной работы №5.
 * Условие
 * В директории лежат входные текстовые файлы, проименованные следующим
 * образом: in_<N>.dat, где N - натуральное число. Каждый файл состоит из двух строк.
 * В первой строке - число, обозначающее действие, а во второй - числа с плавающей
 * точкой, разделенные пробелом. Действия могут быть следующими: 1 – сложение, 2
 * – умножение, 3 - сумма квадратов
 * Необходимо написать многопоточное приложение, которое выполнит требуемые
 * действия над числами и сумму результатов запишет в файл out.dat. Название рабочей
 * директории передается в виде аргумента рабочей строки. В реализации
 * приветствуется использование полиморфизма и паттернов проектирования
 *
 */
public class Main {
    /**
     * Класс Action предназначен для принятия+присваивания типа действий над числами(31-33 стр), а также для реализации
     * упомянутых действий над числами 37-46. Инициализация коллекции чисел numbers
     */
    static class Action {
        private int actionType;
        private List<Double> numbers;

        public Action(int actionType, List<Double> numbers) {
            this.actionType = actionType;
            this.numbers = numbers;
        }

        public double execute() {
            switch (actionType) {
                case 1:
                    return numbers.stream().mapToDouble(Double::doubleValue).sum();
                case 2:
                    return numbers.stream().mapToDouble(Double::doubleValue).reduce(1, (a, b) -> a * b);
                case 3:
                    return numbers.stream().mapToDouble(num -> Math.pow(num, 2)).sum();
                default:
                    return 0;
            }
        }
    }

    /**
     * Функция для чтения файла с разделением ряда по пробелам
     *  Запись в numbers
     *  Передача аргументов actionType и numbers а класс Action
     *  Возвращаем метод execute
     */
    static double processFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int actionType = Integer.parseInt(reader.readLine().trim());
            List<Double> numbers = new ArrayList<>();
            for (String num : reader.readLine().trim().split(" ")) {
                numbers.add(Double.parseDouble(num));
            }
            Action action = new Action(actionType, numbers);
            return action.execute();
        }
    }

    /**
     * Так как работа посвящена мультитредингу, уделю реализации этого процесса больше времени.
     * Этот класс реализует многопоточную обработку файлов в заданной директории.
     * Сначала создается пустой список потоков threads и проходится по всем файлам в директории dir.
     * Если имя файла начинается с "in_" и заканчивается на ".dat", то создается новый поток t,
     * который вызывает метод processFile для обработки файла и добавляет результат в переменную sum.
     * Затем поток t добавляется в список threads и запускается.
     * После того, как все потоки были запущены, программа ждет, пока они завершатся, вызывая метод join
     * для каждого потока из списка threads.
     * После завершения всех потоков возвращается значение переменной sum,
     * содержащей общую сумму результатов обработки всех файлов.
     */
    static double processDirectoryMultithreaded(File dir) throws InterruptedException {
        final double[] sum = {0};

        List<Thread> threads = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.getName().startsWith("in_") && file.getName().endsWith(".dat")) {
                Thread t = new Thread(() -> {
                    try {
                        sum[0] +=processFile(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                threads.add(t);
                t.start();
            }
        }
        for (Thread t : threads) {
            t.join();
        }
        return sum[0];
    }

    /**
     *
     *Запись релущьтата в файл
     */
    static void writeResult(double result, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(Double.toString(result));
        }
    }

    /**
     *
     * Тут мы начинаем.
     * Передаем методу путь к дирректории
     * Затем передаем рузультат в метод записи
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String dirPath = "C:\\Users\\User\\IdeaProjects\\lab5\\dir";
        File dir = new File(dirPath);
        double result = processDirectoryMultithreaded(dir);
        writeResult(result, new File(dir, "out.dat"));
    }
}