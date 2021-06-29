package task06.epam.task2;

import java.util.Scanner;

/**
 * Класс Заметки
 *
 * @author faciorys
 */
public class NoteFind {
    public NoteFind() {
    }

    /*
     * Поиск по Дате
     */
    public void findDate() {
        Scanner scanner = new Scanner(System.in);
        Notebook note = new Notebook();
        User one = new User();
        while (true) {
            System.out.println("Поиск по дате формата dd/mm/yyyy");
            String d = scanner.nextLine();
            if (one.regularExpressionForDate(d)) {
                for (int i = 0; i < note.getNotebookList().size(); i++) {
                    if (note.getNotebookList().get(i).getDate().equals(d)) {
                        System.out.println(note.getNotebookList().get(i).getTopic() + "\n" +
                                note.getNotebookList().get(i).getDate() + "\n" +
                                note.getNotebookList().get(i).getEmail() + "\n" +
                                note.getNotebookList().get(i).getMessage() + "\n");
                    }
                }
                break;
            }
            System.out.println("Неправильный ввод, повторите еще раз (формат dd/mm/yyyy) ");
        }
    }

    /*
     * Поиск по Email
     */
    public void findEmail() {
        Scanner scanner = new Scanner(System.in);
        Notebook note = new Notebook();
        User one = new User();
        while (true) {
            System.out.println("Поиск по email: ");
            String d = scanner.nextLine();
            if (one.regularExpressionForEmail(d)) {
                for (int i = 0; i < note.getNotebookList().size(); i++) {
                    if (note.getNotebookList().get(i).getEmail().equals(d)) {
                        System.out.println(note.getNotebookList().get(i).getTopic() + "\n" +
                                note.getNotebookList().get(i).getDate() + "\n" +
                                note.getNotebookList().get(i).getEmail() + "\n" +
                                note.getNotebookList().get(i).getMessage() + "\n");
                    }
                }
                break;
            }
            System.out.println("Неправильный ввод, повторите еще раз (Пример: gooogle@gmail.com)");
        }
    }

    /*
     * Поиск по Теме (которое содержит слово или предложение)
     */
    public void findTopic() {
        Scanner scanner = new Scanner(System.in);
        Notebook note = new Notebook();
        System.out.println("Поиск по Теме: (введите предложение или слово) ");
        String d = scanner.nextLine();
        for (int i = 0; i < note.getNotebookList().size(); i++) {
            if (note.getNotebookList().get(i).getTopic().contains(d)) {
                System.out.println(note.getNotebookList().get(i).getTopic() + "\n" +
                        note.getNotebookList().get(i).getDate() + "\n" +
                        note.getNotebookList().get(i).getEmail() + "\n" +
                        note.getNotebookList().get(i).getMessage() + "\n");
            }
        }
    }

    /*
     * Поиск по Сообщению (которое содержит слово или предложение)
     */
    public void findMessage() {
        Scanner scanner = new Scanner(System.in);
        Notebook note = new Notebook();
        System.out.println("Поиск по Сообщению: (введите предложение или слово) ");
        String d = scanner.nextLine();
        for (int i = 0; i < note.getNotebookList().size(); i++) {
            if (note.getNotebookList().get(i).getMessage().contains(d)) {
                System.out.println(note.getNotebookList().get(i).getTopic() + "\n" +
                        note.getNotebookList().get(i).getDate() + "\n" +
                        note.getNotebookList().get(i).getEmail() + "\n" +
                        note.getNotebookList().get(i).getMessage() + "\n");
            }
        }
    }
}
