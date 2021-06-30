package epam.task.task09;

/*
* 9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
* */
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
