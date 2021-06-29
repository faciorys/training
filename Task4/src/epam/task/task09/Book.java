package epam.task.task09;

public class Book {
    private int id;
    private static int ID;
    private int year_publishing, number_of_pages, cost;
    private String nameBook, author, publishing, binding_type;

    public Book(String nameBook, String author, String publishing, int year_publishing,
                int number_of_pages, int cost, String binding_type) {
        this.year_publishing = year_publishing;
        this.number_of_pages = number_of_pages;
        this.cost = cost;
        this.nameBook = nameBook;
        this.author = author;
        this.publishing = publishing;
        this.binding_type = binding_type;
    }

    @Override
    public String toString() {
        return "Книга: " + nameBook + "; Автор: " + author + "; Издательство: " + publishing +
                "; Год публикации: " + year_publishing +
                "; Количество страниц: " + number_of_pages +
                "; Цена: " + cost + "$" +
                "; Тип переплета: " + binding_type;
    }

    public int getYear_publishing() {
        return year_publishing;
    }

    public void setYear_publishing(int year_publishing) {
        this.year_publishing = year_publishing;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBinding_type() {
        return binding_type;
    }

    public void setBinding_type(String binding_type) {
        this.binding_type = binding_type;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }
}
