package task06.epam.task1.library;

/**
 * Класс каталог
 *
 *  @author faciorys
 */
public class Catalog {
    int id;
    String title;
    String author;
    String typeBooks;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTypeBooks() {
        return typeBooks;
    }

    public Catalog(int id, String title, String author, String typeBooks) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.typeBooks = typeBooks;
    }

    @Override
    public String toString() {
        return String.format("%-3d%-15s%-12s%-12s", id, title, author, typeBooks);
    }

    public static Catalog getBooks(String str) {
        String id = str.substring(0, 3).trim();
        String title = str.substring(3, 18).trim();
        String author = str.substring(18, 30).trim();
        String typeBook = str.substring(30, 42).trim();
        return new Catalog(Integer.parseInt(id), title, author, typeBook);
    }
}
