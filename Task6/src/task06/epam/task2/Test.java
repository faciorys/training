package task06.epam.task2;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/*
* Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
Общие пояснения к практическому заданию.
• В начале работы приложения данные должны считываться из файла, в конце
работы – сохраняться в файл.
• У пользователя должна быть возможность найти запись по любому параметру
или по группе параметров (группу параметров можно определить
самостоятельно), получить требуемые записи в отсортированном виде, найти
записи, текстовое поле которой содержит определенное слово, а также
добавить новую запись.
• Особое условие: поиск, сравнение и валидацию вводимой информации
осуществлять с использованием регулярных выражений.
• Особое условие: проверку введенной информации на валидность должен
осуществлять код, непосредственно добавляющий информацию.
* */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Notebook notebook = new Notebook();
        boolean flaq = true;
        int s;
        System.out.println("Количество заметок в блокноте " + notebook.getNotebookList().size());
        while (flaq) {
            System.out.println("1. Добавить Заметку\n2. Сортировать заметки\n" +
                    "3. Показать все заметки\n4. Искать заметку\n5. Выход");
            while (true) {
                s = scanner.nextInt();
                if (s >= 0 && s <= 5) {
                    break;
                }
                System.out.println("Повторите ввод от 0 до 5");
            }
            if (s == 1) {
                User user = new User();
                user.getAddNotes(scanner);
            } else if (s == 2) {
                System.out.println("Сортировать заметки по: 1) Теме\n" +
                        "2) Дате\n3) Email\n4) Сообщению");
                int choose;
                while (true) {
                    choose = scanner.nextInt();
                    if (choose >= 1 && choose <= 4) {
                        break;
                    }
                    System.out.println("Повторите ввод от 1 до 4");
                }
                if (choose == 1) {
                    notebook.sortTopic();
                } else if (choose == 2) {
                    notebook.sortDate();
                } else if (choose == 3) {
                    notebook.sortEmail();
                } else if (choose == 4) {
                    notebook.sortMessage();
                }
            } else if (s == 3) {
                Notebook notebook1 = new Notebook();
                notebook1.showAllNotes();
            } else if (s == 4) {
                System.out.println("Искать заметки по: 1) Теме\n" +
                        "2) Дате\n3) Email\n4) Сообщению");
                NoteFind note = new NoteFind();
                int ch;
                while (true) {
                    ch = scanner.nextInt();
                    if (ch >= 1 && ch <= 4) {
                        break;
                    }
                    System.out.println("Повторите ввод от 1 до 4");
                }
                if (ch == 1) {
                    note.findTopic();
                } else if (ch == 2) {
                    note.findDate();
                } else if (ch == 3) {
                    note.findEmail();
                } else if (ch == 4) {
                    note.findMessage();
                }
            } else if (s == 5) {
                flaq = false;
                System.out.println("Досвидания");
            }
        }
    }
}
