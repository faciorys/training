package task06.epam.task3;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/*
* Задание 3: создайте клиент-серверное приложение “Архив”.
Общие требования к заданию:
• В архиве хранятся Дела (например, студентов). Архив находится на сервере.
• Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
него изменения, или создать новое дело.
Требования к коду лабораторной работы:
• Для реализации сетевого соединения используйте сокеты.
• Формат хранения данных на сервере – xml-файлы.
* */
public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Соединение с сервером установлено");
        while (true) {
            Socket clientSocket = new Socket("127.0.0.1", 8000);
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            System.out.println("Введите цифру от 1 до 4 " +
                    "(1 - просмотреть все дела; 2 - просмотреть дело определенного студента; " +
                    "\n3 - изменить характеристику студента; 4 - добавить новое дело; exit - прервать соединение)");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                writer.write(input);
                writer.newLine();

            } else if (input.equals("2")) {
                System.out.println("Введите фамилию студента для просмотра его дела");
                writer.write(input + Server.DELIMITER + scanner.nextLine());
                writer.newLine();

            } else if (input.equals("3")) {
                System.out.println("Введите фамилию студента для изменения его характеристики");
                writer.write(input + Server.DELIMITER + scanner.nextLine() + Server.DELIMITER);
                System.out.println("Внесите данные, которые желаете изменить в характеристике студента");
                writer.write(scanner.nextLine());
                writer.newLine();

            } else if (input.equals("4")) {
                System.out.println("Создаем новое дело");
                System.out.println("Введите фамилию студента:");
                writer.write(input + Server.DELIMITER + scanner.nextLine() + Server.DELIMITER);
                System.out.println("Введите возраст:");
                writer.write(scanner.nextLine() + Server.DELIMITER);
                System.out.println("Введите курс:");
                writer.write(scanner.nextLine() + Server.DELIMITER);
                System.out.println("Введите его характеристику:");
                writer.write(scanner.nextLine());
                writer.newLine();

            } else if (input.equals("exit")) {
                System.out.println("Соединение с сервером прервано");
                writer.close();
                reader.close();
                clientSocket.close();
                break;

            } else {
                writer.write(input + "\n");
            }

            writer.flush();

            String readerL = reader.readLine();
            if (readerL.length() != 0) {
                String[] strings = readerL.split(Server.DELIMITER);
                for (String st : strings) {
                    System.out.println(st);
                }
            }
            writer.close();
            reader.close();
        }
    }
}
