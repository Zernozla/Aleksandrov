/**
 * @author <strong>Aleksandrov Aleksandr</strong>
 * @version 0.0.7
 * @since 0.0.1
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * На вход программы подается произвольный файл, необходимо извлечь из него все ip адреса.
 * В файле могут встречаться как IPv4 так и Ipv6 адреса например,
 * 127.0.0.1 или fe80:0:0:0:200:f8ff:fe21:67cf
 * Отсортировать ip адреса по возрастанию (сначала IPv4, затем IPv6).
 */
public class Main {
    public static void main(String[] args) {
        String filename = "IP.txt";
        String outputFilename = "OUT.txt";
        /**
         * создание прокаченных массивов
         */
        ArrayList<String> ipv4Addresses = new ArrayList<>();
        ArrayList<String> ipv6Addresses = new ArrayList<>();
        /**
         * Чтение входных данных, добавление в ip адрессов в соответствующие массивы согласно их regex паттерну
         */
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Pattern ipv4Pattern = Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
                Matcher ipv4Matcher = ipv4Pattern.matcher(line);
                while (ipv4Matcher.find()) {
                    ipv4Addresses.add(ipv4Matcher.group());

                }
                Pattern ipv6Pattern = Pattern.compile("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
                Matcher ipv6Matcher = ipv6Pattern.matcher(line);
                while (ipv6Matcher.find()) {
                    ipv6Addresses.add(ipv6Matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * сортировка по возрастанию
         */
        Collections.sort(ipv4Addresses);
        Collections.sort(ipv6Addresses);

        ArrayList<String> sortedAddresses = new ArrayList<>();
        /**
         * слияние двух массивов в один, а также запись в файл
         */
        sortedAddresses.addAll(ipv4Addresses);
        sortedAddresses.addAll(ipv6Addresses);
        try (FileWriter fw = new FileWriter(outputFilename)) {
            for (String address : sortedAddresses) {
                fw.write(address + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}