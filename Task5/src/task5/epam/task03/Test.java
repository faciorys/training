package task5.epam.task03;

import java.time.LocalDate;

/*
* Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
* выходных и праздничных днях.
* */
public class Test {
    public static void main(String[] args) {
        Calendar calendar2021 = new Calendar();
        calendar2021.add(new Calendar.Information(LocalDate.parse("2021-03-08"),"Женский день"));
        calendar2021.add(new Calendar.Information(LocalDate.parse("2021-01-01"),"Новый год"));
        calendar2021.add(new Calendar.Information(LocalDate.parse("2021-06-19"),"Выходной"));
        System.out.println(calendar2021.toString());
        calendar2021.findDate(LocalDate.parse("2021-06-29"));
        calendar2021.findDate(LocalDate.parse("2021-06-19"));
    }
}
