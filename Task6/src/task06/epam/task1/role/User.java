package task06.epam.task1.role;

import task06.epam.task1.library.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс Пользователь
 *
 *  @author faciorys
 */
public class User {
    public static boolean open = false;
    private String user;
    private String password;
    private List<User> usersList;

    public String getUser() {
        return user;
    }


    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User() {
        usersList = new ArrayList<>();
        usersCatalog();
    }

    /*
     * Метод в котором пользователь предлаегает добавить книгу в библиотеку
     */
    public void wishAddBook(Scanner scanner) {
        Library library = new Library();
        library.booksPending(scanner);
    }

    /*
     * Показать все книги
     */
    public void showAllBooks() {
        Library library = new Library();
        library.showAllBooks();
    }

    /*
     * Поиск книги в каталоге по названию
     */
    public void searchBookByTitle(Scanner scanner) {
        Library library = new Library();
        System.out.println("Введите название книги:");
        library.searchBookByTitle(scanner.next());
    }

    /*
     * Поиск книги в каталоге по автору
     */
    public void searchBookByAuthor(Scanner scanner) {
        Library library = new Library();
        System.out.println("Введите автора книги:");
        library.searchBookByAuthor(scanner.next());
    }

    /*
     * Поиск книги в каталоге по типу
     */
    public void searchBookByType(Scanner scanner) {
        Library library = new Library();
        System.out.println("Введите тип книги:");
        library.searchBookByType(scanner.next());
    }

    /*
     * Поиск пользователя в Базе users.txt
     */
    public void findUser(String login, String password) {
        User name = new User();
        String log = login;
        String pass = password;
        for (User u : name.usersList) {
            int count = 0;
            if (log.equals(u.user.trim())) {
                count++;
            }
            if (pass.equals(u.password.trim())) {
                count++;
                if (count == 2) {
                    System.out.println("Вы вошли в свой аккаунт");
                    open = true;
                    break;
                }
            }
        }
    }

    /*
     * Регистрация нового пользователя
     */
    public static User getRegistration(Scanner scanner) {
        User name = new User();
        User one = new User("", "");
        System.out.println("Регистрация нового пользователя");
        System.out.println("Введите вашу почту: (max = 27 символов) ");
        while (true) {
            int count = 0;
            one.user = scanner.next();
            if (one.regularExpression(one.user)) {
                for (int i = 0; i < name.usersList.size(); i++) {
                    if (one.user.equals(name.usersList.get(i).user)) {
                        count++;
                    }
                }
                if (count == 0) {
                    if (one.user.length() <= 27 && one.user.length() != 0) {
                        break;
                    }
                }
                if (count > 0) {
                    System.out.println("Такая почта уже зарегестрирована, введите другую");
                } else
                    System.out.println("Не корректный ввод. Повторите действие.");
            }
            System.out.println("Не корректный ввод. Повторите действие.");
        }
        System.out.println("Введите пароль");
        one.password = scanner.next();
        System.out.println("Вы успешно зарегестрированы");
        StringBuilder o = new StringBuilder(one.user);
        StringBuilder p = new StringBuilder(one.password);
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\users.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(catalog, true))) {
            for (int b = one.user.length(); b < 28; b++) {
                o.append(" ");
            }
            writer.write(String.valueOf(o));
            for (int b = one.password.length(); b < 10; b++) {
                p.append(" ");
            }
            writer.write(String.valueOf(p));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new User(one.user, one.password);
    }

    /*
     * Метод "загрузки" всех пользователей библиотеки.
     */
    private void usersCatalog() {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        List<User> users = new ArrayList<>();
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(catalog))) {
            while (reader.ready()) {
                User users1 = getUser(reader.readLine());
                users.add(users1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < users.size(); i++) {
            usersList.add(new User(users.get(i).user, users.get(i).password));
        }
    }

    /*
     * Регулярное выражение для ввода (логина - почты)
     */
    public boolean regularExpression(String rv) {
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(rv);
        boolean matches = matcher.matches();
        return matches;
    }

    public static User getUser(String str) {
        String user = str.substring(0, 28).trim();
        String password = str.substring(28, 38).trim();
        return new User(user, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
