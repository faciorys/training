package epam.task.task09;

public class Main {
    public static void main(String[] args) {
        Book one = new Book("Alone", "Diego", "House LTD",1970,
                120,20,"Тряпка");
        Books zero = new Books();
        zero.add(one);
        zero.add(new Book("Forever", "Diego", "House MMM",1969,
                1220,10,"Дерево"));
        zero.printBookPublishing("House LTD");
        zero.printBookAuthor("Diego");
        zero.printBookYearPublishing(1964);
    }
}
