package task06.epam.task3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Класс DOMxmlEdit для редактирования и создания дел студентов из xml-файла
 *
 * @author faciorys
 */
public class DOMxmlEdit {
    private static String ts, ts1;
    private static String addSt1, addSt2, addSt3, addSt4;

    /*
     * Метод редактирования дела студента (его характеристики)
     */
    public String makeChanges(String st, String st1) {
        ts = st;
        ts1 = st1;
        String filePath = "src/task06/epam/task3/archive/archive.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // обновляем характеристику студента
            updateElementValue(doc);

            // запишем отредактированный элемент в файл

            recording(doc);

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return st;
    }

    /*
     * Метод создания нового дела студента
     */
    public String makeChanges(String st1, String st2, String st3, String st4) {
        addSt1 = st1;
        addSt2 = st2;
        addSt3 = st3;
        addSt4 = st4;
        String filePath = "src/task06/epam/task3/archive/archive.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //  добавляем новый элемент
            addElements(doc);

            // запишем отредактированный элемент в файл
            recording(doc);


        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return "Новое дело создано";
    }

    //   Добавление нового дела студента
    private static void addElements(Document doc) {
        NodeList studentsList = doc.getElementsByTagName("students");
        Element lang = null;

        //проходим по каждому элементу studentsList
        for (int i = 0; i < studentsList.getLength(); i++) {
            lang = (Element) studentsList.item(i);
            Element newElement = doc.createElement("student");
            newElement.setAttribute("name", addSt1);
            newElement.setAttribute("age", addSt2);
            newElement.setAttribute("course", addSt3);
            newElement.setAttribute("characteristic", addSt4);

            lang.appendChild(newElement);
        }
    }


    // изменяем значение существующего элемента name
    private static void updateElementValue(Document doc) throws IOException, SAXException, ParserConfigurationException {
        DOMStudent d = new DOMStudent();
        d.parsing();

        NodeList studentsList = doc.getElementsByTagName("student");
        Element lang = null;
        // проходим по каждому элементу
        boolean flag = true;
        for (int i = 0; i < studentsList.getLength(); i++) {
            if (DOMStudent.getStudents().get(i).getName().equals(ts)) {
                lang = (Element) studentsList.item(i);
                String s = lang.getAttribute("characteristic");
                lang.setAttribute("characteristic", ts1);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(ts + " данного студента нет в базе данных");
        }
    }

    private static void recording(Document doc) throws TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/task06/epam/task3/archive/archive.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML успешно изменен!");
    }
}