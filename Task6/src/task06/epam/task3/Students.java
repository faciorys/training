package task06.epam.task3;

/**
 * Класс Students
 *
 * @author faciorys
 */
public class Students {
    private String name;
    private String age, course;
    private String characteristic;

    public String getCharacteristic() {
        return characteristic;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public Students(String name, String age, String course, String characteristic) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.characteristic = characteristic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}