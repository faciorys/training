package task06.epam.task1.role;

import task06.epam.task1.library.Books;
import task06.epam.task1.library.Catalog;
import task06.epam.task1.library.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс Администратор
 *
 *  @author faciorys
 */
public class Admin {
    public static boolean open_admin = false;
    private String admin;
    private String password;
    private List<Admin> adminsList;

    public Admin(String admin, String password) {
        this.admin = admin;
        this.password = password;
    }

    public Admin() {
        adminsList = new ArrayList<>();
        adminCatalog();
    }

    public String getAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    /*
     * Просмотр книг из каталога на рассмотрении (books-pending)
     */
    public void catalogBooksPending() {
        List<Catalog> addBook = new ArrayList<>();
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\books-pending.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(catalog))) {
            while (reader.ready()) {
                Catalog books = Catalog.getBooks(reader.readLine());
                addBook.add(books);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < addBook.size(); i++) {
            System.out.println(addBook.get(i).getTitle() + " " + addBook.get(i).getAuthor() + " "
                    + addBook.get(i).getTypeBooks());
        }
    }

    /*
     * Добавить книгу из каталога на рассмотрении (books-pending)
     */
    public void addBook() throws IOException {
        Library l = new Library();
        List<Catalog> addBooks = new ArrayList<>();
        int id = 0;
        StringBuilder u;
        String catBf = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\books-pending.txt";
        String catBw = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\catalog.txt";
        try (BufferedReader bf = new BufferedReader(new FileReader(catBf));
             BufferedWriter bw = new BufferedWriter(new FileWriter(catBw, true))) {
            while (bf.ready()) {
                id++;
                Catalog books = Catalog.getBooks(bf.readLine());
                addBooks.add(books);
                int count = l.getBooksList().size() + id;
                u = new StringBuilder(String.valueOf(count));
                while (u.length() != 3) {
                    u.append(" ");
                }
                bw.write(String.valueOf(u));
                u = new StringBuilder(addBooks.get(0).getTitle());
                while (u.length() != 15) {
                    u.append(" ");
                }
                bw.write(String.valueOf(u));
                u = new StringBuilder(addBooks.get(0).getAuthor());
                while (u.length() != 15) {
                    u.append(" ");
                }
                bw.write(String.valueOf(u));
                u = new StringBuilder(addBooks.get(0).getTypeBooks());
                while (u.length() != 15) {
                    u.append(" ");
                }
                bw.write(String.valueOf(u));

                bw.newLine();
                bw.flush();

                System.out.println("Книга " + addBooks.get(0).getTitle() + " Автора " + addBooks.get(0).getAuthor()
                        + " добавлена в библиотеку и извещения отправлены на почты пользователям:");
                mailing_to_email();
                addBooks.clear();
            }
        }
    }

    /*
     * Метод извещения пользователей о новой книге
     */
    private void mailing_to_email() throws IOException {
        List<User> users1 = new ArrayList<>();
        String users = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\users.txt";
        try (BufferedReader bf = new BufferedReader(new FileReader(users))) {
            while (bf.ready()) {
                User user = User.getUser(bf.readLine());
                users1.add(user);
            }
        }
        for (int i = 0; i < users1.size(); i++)
            System.out.println(users1.get(i).getUser());
    }

    /*
     * Сортировка книг по названию
     */
    public void sortBookTitle() throws IOException {
        Library l = new Library();
        l.getBooksList().sort(new Comparator<Books>() {
            @Override
            public int compare(Books o1, Books o2) {
                return o1.getTitleBook().compareTo(o2.getTitleBook());
            }
        });
        sort(l);
    }

    /*
     * Сортировка книг по Автору
     */
    public void sortBookAuthor() throws IOException {
        Library l = new Library();
        l.getBooksList().sort(new Comparator<Books>() {
            @Override
            public int compare(Books o1, Books o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        sort(l);
    }

    /*
     * Сортировка книг по жанру
     */
    public void sortBookType() throws IOException {
        Library l = new Library();
        l.getBooksList().sort(new Comparator<Books>() {
            @Override
            public int compare(Books o1, Books o2) {
                return o1.getTypeBooks().compareTo(o2.getTypeBooks());
            }
        });
        sort(l);
    }

    /*
     * Метод сортировки
     */
    private void sort(Library library) throws IOException {
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\catalog.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(catalog, false))) {
            int id = 0;
            for (Books book : library.getBooksList()) {
                id++;
                String Id = String.valueOf(id);
                if (id < 10) {
                    Id = String.valueOf(id + "  ");
                } else if (id >= 10 && id < 100) {
                    Id = String.valueOf(id + " ");
                }
                bufferedWriter.write(Id);
                StringBuilder title = new StringBuilder(book.getTitleBook());
                while (title.length() != 15) {
                    title.append(" ");
                }
                bufferedWriter.write(String.valueOf(title));
                StringBuilder author = new StringBuilder(book.getAuthor());
                while (author.length() != 12) {
                    author.append(" ");
                }
                bufferedWriter.write(String.valueOf(author));
                StringBuilder type = new StringBuilder(book.getTypeBooks());
                while (type.length() != 12) {
                    type.append(" ");
                }
                bufferedWriter.write(String.valueOf(type));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
    }

    /*
     * Метод (поиск в базе данных логина и пароля) на вход в библиотеку администратора
     */
    public void findAdmin(String login, String password) {
        Admin name = new Admin();
        String log = login;
        String pass = password;
        for (Admin u : name.adminsList) {
            int count = 0;
            if (log.equals(u.admin.trim())) {
                count++;
            }
            if (pass.equals(u.password.trim())) {
                count++;
                if (count == 2) {
                    System.out.println("Добро пожаловать Админ");
                    open_admin = true;
                    break;
                }
            }
        }
    }

    /*
     * База данных (логин и пароль администраторов)
     */
    private void adminCatalog() {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        List<Admin> admins = new ArrayList<>();
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\admin.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(catalog))) {
            while (reader.ready()) {
                Admin admin = getAdmin(reader.readLine());
                admins.add(admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < admins.size(); i++) {
            adminsList.add(new Admin(admins.get(i).admin, admins.get(i).password));
        }
    }

    public static Admin getAdmin(String str) {
        String admin = str.substring(0, 28).trim();
        String password = str.substring(28, 38).trim();
        return new Admin(admin, password);
    }
}