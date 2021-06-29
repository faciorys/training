package epam.task.task03;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String surname;
    String firstname;
    String patronymic;
    int group_number;
    int[] progress = new int[5];

    public Student(String surname, String firstname, String patronymic, int group_number, int[] progress) {
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.group_number = group_number;
        this.progress = progress;
    }

    public Student() {
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "Иван", "Иванович", 3,
                new int[]{1, 4, 5, 6, 7}));
        students.add(new Student("Сергеев", "Алексей", "Иакович", 2,
                new int[]{10, 10, 10, 9, 8}));
        students.add(new Student("Петушков", "Иван", "Степанович", 3,
                new int[]{9, 9, 10, 10, 10}));
        students.add(new Student("Собянин", "Иван", "Иванович", 3,
                new int[]{1, 4, 5, 6, 7}));
        students.add(new Student("Димитриеску", "Петр", "Иванович", 1,
                new int[]{1, 4, 5, 6, 7}));
        students.add(new Student("Даль", "Иван", "Иванович", 3,
                new int[]{1, 2, 5, 6, 7}));
        students.add(new Student("Спец", "Иван", "Иванович", 3,
                new int[]{1, 3, 5, 6, 7}));
        students.add(new Student("Мошич", "Иван", "Абрамович", 3,
                new int[]{4, 4, 5, 6, 7}));
        students.add(new Student("Демидов", "Иван", "Иванович", 4,
                new int[]{9, 9, 9, 7, 10}));
        students.add(new Student("Иванченко", "Иван", "Иванович", 1,
                new int[]{9, 9, 9, 9, 10}));

        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            for (int a = 0; a < students.get(i).progress.length; a++) {
                if (students.get(i).progress[a] >= 9) {
                    count++;
                }
                if (count == 5) {
                    students.get(i).about();
                }

            }
            count = 0;
        }
    }

    void about() {
        System.out.printf("Фамилия: %s  Группа: %d\n", surname, group_number);
    }
}
