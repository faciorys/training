package task06.epam.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс Пользователь блокнота
 *
 * @author faciorys
 */
public class User implements Note {
    public static final String DELIMITER = "--------------------";
    private List<String> userNotesList;
    private String topic;
    private String date;
    private String email;
    private String message;

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public List<String> getUserNotesList() {
        return userNotesList;
    }

    public User(String topic, String date, String email, String message) {
        this.topic = topic;
        this.date = date;
        this.email = email;
        this.message = message;
    }

    public User() {
        userNotesList = new ArrayList<>();
    }

    /*
     * Добавление новой заметки
     */
    public User getAddNotes(Scanner scanner) throws IOException {
        User user = new User("", "", "", "");
        System.out.println("Создаем новую заметку");
        System.out.println("Тема: ");
        String stTopic = scanner.nextLine();
        topic = "<" + scanner.nextLine() + ">";

        while (true) {
            System.out.print("Дата: ");
            date = scanner.nextLine();
            if (regularExpressionForDate(String.valueOf(date))) {
                break;
            }
            System.out.println("Неправильный ввод, повторите еще раз (формат dd/mm/yyyy) ");
        }
        while (true) {
            System.out.print("E-mail: ");
            email = scanner.nextLine();
            if (regularExpressionForEmail(email)) {
                break;
            }
            System.out.println("Неправильный ввод, повторите еще раз (Пример: gooogle@gmail.com)");
        }
        System.out.print("Сообщение: ");
        message = "'" + scanner.nextLine() + "'";
        userNotesList.add(topic);
        userNotesList.add(String.valueOf(date));
        userNotesList.add(email);
        userNotesList.add(message);
        addNewNot();
        return new User(topic, date, email, message);
    }


    private void addNewNot() throws IOException {
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task2\\notebook\\notebook.txt";
        File file = new File(catalog);
        try (FileOutputStream fos = new FileOutputStream(file, true);
             PrintWriter writer = new PrintWriter(fos)) {
            writer.print(topic + "\n");
            writer.print(date + "\n");
            writer.print(email + "\n");
            writer.print(message + "\n");
            writer.print(DELIMITER + "\n");
            writer.flush();
        }
    }

    /*
     * Регулярное выражение для Email
     */
    public boolean regularExpressionForEmail(String email) {
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        boolean matches = matcher.matches();
        return matches;
    }

    /*
     * Регулярное выражение для Даты
     */
    public boolean regularExpressionForDate(String date) {
        Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.]((19|20)\\d\\d)$");
        Matcher matcher = pattern.matcher(date);
        boolean matches = matcher.matches();
        return matches;
    }
}