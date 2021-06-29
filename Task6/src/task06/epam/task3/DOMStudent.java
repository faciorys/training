package task06.epam.task3;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс DOMStudent для чтения дел студентов из xml-файла
 *
 * @author faciorys
 */
public class DOMStudent {
    private static ArrayList<Students> students = new ArrayList<>();

    public void parsing() throws ParserConfigurationException, SAXException, IOException {
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File("src/task06/epam/task3/archive/archive.xml"));

        // Получение списка всех элементов allStudent внутри корневого элемента
        // (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList allStudent = document.getDocumentElement().getElementsByTagName("student");


        // Перебор всех элементов allStudent
        for (int i = 0; i < allStudent.getLength(); i++) {
            Node student = allStudent.item(i);

            // Получение атрибутов каждого элемента
            NamedNodeMap attributes = student.getAttributes();

            // Добавление сотрудника. Атрибут - тоже Node,
            // потому нам нужно получить значение атрибута с помощью метода getNodeValue()
            students.add(new Students(attributes.getNamedItem("name").getNodeValue(),
                    attributes.getNamedItem("age").getNodeValue(),
                    attributes.getNamedItem("course").getNodeValue(),
                    attributes.getNamedItem("characteristic").getNodeValue()));
        }
    }

    public static ArrayList<Students> getStudents() {
        return students;
    }
}