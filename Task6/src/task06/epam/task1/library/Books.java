package task06.epam.task1.library;

/**
 * Класс книги
 *
 *  @author faciorys
 */
public class Books implements Book {
    private int id;
    private String title;
    private String author;
    private String typeBooks;

    public Books(int id, String title, String author, String typeBooks) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.typeBooks = typeBooks;
    }

    public Books(String title, String author, String typeBooks) {
        this.title = title;
        this.author = author;
        this.typeBooks = typeBooks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTypeBooks(String typeBooks) {
        this.typeBooks = typeBooks;
    }

    @Override
    public String getTitleBook() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTypeBooks() {
        return typeBooks;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", typeBooks='" + typeBooks + '\'' +
                '}';
    }
}
