package task06.epam.task3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.net.*;
import java.io.*;

/**
 * Класс Сервер
 *
 * @author faciorys
 */
public class Server {
    public static final String DELIMITER = "///";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

//        создаем серверный сокет - он используется для того, что бы создать серверное подключение
//        и на сервере создать ожидание клиента
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Сервер запущен");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            ServerMethods sm = new ServerMethods();
            String request = reader.readLine();
            String[] req = request.split(DELIMITER);


            if (req[0].equals("1")) {
                writer.write(sm.viewAll(request));
            } else if (req[0].equals("2")) {
                writer.write(sm.viewTheCase(req[1]));
            } else if (req[0].equals("3")) {
                DOMStudent dom = new DOMStudent();
                dom.parsing();
                boolean flag = false;
                for (int i = 0; i < DOMStudent.getStudents().size(); i++) {
                    if (req[1].equals(DOMStudent.getStudents().get(i).getName())) {
                        flag = true;
                    }
                }
                if (flag) {
                    sm.makeChanges(req[1], req[2]);
                    DOMStudent.getStudents().clear();
                    writer.write("измениния в характеристику студента " + req[1] + " внесены");

                } else {
                    writer.write(" данного студента нет в базе данных");
                }

            } else if (req[0].equals("4")) {
                DOMStudent dom = new DOMStudent();
                dom.parsing();
                sm.addNewStudent(req[1], req[2], req[3], req[4]);
                DOMStudent.getStudents().clear();
                writer.write("Новое дело студента " + req[1] + " создано");
            } else
                writer.write("Неверный запрос");
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
    }
}
