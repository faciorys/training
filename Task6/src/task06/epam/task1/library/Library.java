package task06.epam.task1.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс Библиотека
 *
 *  @author faciorys
 */
public class Library {
    private List<Books> booksList;
    private String title_book;
    private String author;
    private String UserBase;

    public List<Books> getBooksList() {
        return booksList;
    }

    public String getTitle_book() {
        return title_book;
    }

    public String getAuthor() {
        return author;
    }

    public String getUserBase() {
        return UserBase;
    }

    public Library() {
        booksList = new ArrayList<>();
        catalogBook();
    }

    /*
     * Метод показать все книги
     */
    public void showAllBooks() {
        booksList.forEach(System.out::println);
    }

    /*
     * Метод поиска книг по Названию
     */
    public void searchBookByTitle(String string) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getTitleBook().contains(string)) {
                System.out.println(booksList.get(i));
            }
        }
    }

    /*
     * Метод поиска книг по Автору
     */
    public void searchBookByAuthor(String string) {
        for (Books b : booksList) {
            if (b.getAuthor().contains(string)) {
                System.out.println(b.toString());
            }
        }
    }

    /*
     * Метод поиска книг по типу
     */
    public void searchBookByType(String string) {
        for (Books b : booksList) {
            if (b.getTypeBooks().contains(string)) {
                System.out.println(b.toString());
            }
        }
    }

    /*
     * Метод добавления книг в каталог на рассмотрение (books-pending)
     */
    public void addBook() throws IOException {
        List<Catalog> newBook = new ArrayList<>();
        String booksPending = ("C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\books-pending.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(booksPending))) {
            while (reader.ready()) {
                Catalog books = Catalog.getBooks(reader.readLine());
                newBook.add(books);
            }
            String id = String.valueOf(booksList.size()) + " ";
            booksList.add(new Books(Integer.parseInt(id), newBook.get(0).title, newBook.get(0).author,
                    newBook.get(0).typeBooks));

        }
    }

    /*
     * Каталог книг
     */
    private void catalogBook() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Catalog> addBook = new ArrayList<>();
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\catalog.txt";
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
            booksList.add(new Books(addBook.get(i).id, addBook.get(i).title, addBook.get(i).author,
                    addBook.get(i).typeBooks));
        }
    }

    /*
     * Книги на рассмотрении
     */
    public Books booksPending(Scanner scanner) {
        Books name = new Books(11, "", "", "");
        System.out.println("Введите название книг: ");
        name.setTitle(scanner.next());
        System.out.println("Введите автора: ");
        name.setAuthor(scanner.next());
        System.out.println("Введите тип жанра: ");
        name.setTypeBooks(scanner.next());
        StringBuilder tib = new StringBuilder(name.getTitleBook());
        StringBuilder aTh = new StringBuilder(name.getAuthor());
        StringBuilder tyB = new StringBuilder(name.getTypeBooks());
        String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task1\\file\\books-pending.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(catalog, true))) {
            writer.write("1  ");
            for (int b = tib.length(); b < 15; b++) {
                tib.append(" ");
            }
            writer.write(String.valueOf(tib));
            for (int b = aTh.length(); b < 12; b++) {
                aTh.append(" ");
            }
            writer.write(String.valueOf(aTh));
            writer.write(String.valueOf(tyB));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Books(getBooksList().size() + 1, name.getTitleBook(), name.getAuthor(), name.getTypeBooks());
    }

}
