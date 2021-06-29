package task06.epam.task3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Класс Методы Сервера
 *
 * @author faciorys
 */
public class ServerMethods {
    /*
     * Метод показать дела всех студентов
     */
    public String viewAll(String string) throws IOException, SAXException, ParserConfigurationException {
        StringBuilder sb = new StringBuilder();
        DOMStudent d = new DOMStudent();
        d.parsing();
        for (Students student : DOMStudent.getStudents()) {
            sb.append(student.toString() + Server.DELIMITER);
        }
        DOMStudent.getStudents().clear();
        String words = String.valueOf(sb);
        return words;
    }

    /*
     * Метод показать дело определенного студента
     */
    public String viewTheCase(String string) throws IOException, SAXException, ParserConfigurationException {
        StringBuilder sb = new StringBuilder();
        DOMStudent d = new DOMStudent();
        d.parsing();
        boolean flaq = false;
        for (Students student : DOMStudent.getStudents()) {
            if (student.getName().equals(string)) {
                sb.append(student.toString() + " " + student.getCharacteristic() + Server.DELIMITER);
                flaq = true;
            }
        }
        DOMStudent.getStudents().clear();
        if (!flaq) {
            return "Данный студент отсутствует в базе данных";
        }
        String words = String.valueOf(sb);
        return words;
    }

    /*
     * Метод изменения дела (характеристики) определенного студента
     */
    public String makeChanges(String string, String string1) {
        DOMxmlEdit doMxmlEdit = new DOMxmlEdit();
        doMxmlEdit.makeChanges(string, string1);
        return string;
    }

    /*
     * Метод создания нового дела
     */
    public String addNewStudent(String s1, String s2, String s3, String s4) {
        DOMxmlEdit doMxmlEdit = new DOMxmlEdit();
        doMxmlEdit.makeChanges(s1, s2, s3, s4);
        return "все ок";
    }
}
