package epam.task.task09;

public class Books {
    private Book[] books;
    private int capacity;
    private int size;

    public Books(int capacity) {
        size = 0;
        this.capacity = capacity;
        books = new Book[capacity];
    }

    public Books() {
        this(10);
    }

    public void add(Book book) {
        if (size < capacity) {
            books[size] = book;
            size++;
        } else {
            Book[] temp = new Book[capacity + 5];
            for (int i = 0; i < size; ++i) {
                temp[i] = books[i];
            }
            books = temp;
            capacity = capacity + 5;
            books[size] = book;
            size++;
        }
    }

    public void printBookPublishing(String publishing) {
        System.out.println("Список книг выпущенных издательством: " + publishing);
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (books[i].getPublishing().equals(publishing)) {
                count++;
                System.out.println(books[i].getNameBook());
            }
        }
        if (count == 0) {
            System.out.println("Книг выпущенных " + publishing + " издательством нету.");
        }
    }
    public void printBookAuthor(String author) {
        System.out.println("Список книг автора: " + author);
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (books[i].getAuthor().equals(author)) {
                count++;
                System.out.println(books[i].getNameBook());
            }
        }
        if (count == 0) {
            System.out.println("Книг автора " + author + " нету в базе данных");
        }
    }
    public void printBookYearPublishing(int year) {
        System.out.println("Список книг выпущенных после: " + year);
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (books[i].getYear_publishing() >  year) {
                count++;
                System.out.println(books[i].getNameBook());
            }
        }
        if (count == 0) {
            System.out.println("Список книг выпущенных после: " + year + " нету в базе данных");
        }
    }
}
