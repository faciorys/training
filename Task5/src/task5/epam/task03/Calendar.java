package task5.epam.task03;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Calendar {
    List<Information> day;

    public Calendar(List<Information> day) {
        if (day != null) {
            this.day = day;
        } else {
            this.day = new ArrayList<>();
        }
    }

    public Calendar() {
        this(null);
    }

    public boolean add(Information info) {
        return day.add(info);
    }

    // поиск по дате
    public void findDate(LocalDate date) {
        Information inf = new Information(date, " ");
        int count = 0;
        for (Information d : day) {
            if (d.getDate().equals(date)) {
                System.out.println(d.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println(date + " : Данные о дате отсутствуют в календаре");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Information d : day) {
            result.append(d).append('\n');
        }
        if (result.length() > 0) result.setLength(result.length() - 1);
        return result.toString();
    }

    public static class Information {
        public LocalDate date;
        public String info;

        public Information(LocalDate date, String info) {
            this.date = date;
            this.info = info;
        }

        public LocalDate getDate() {
            return date;
        }

        public String toString() {
            Locale localeRu = new Locale("ru", "RU");
            return date + " : " + info + " (" + date.getDayOfWeek().getDisplayName(TextStyle.FULL, localeRu) + ")";
        }
    }
}
