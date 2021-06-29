package task06.epam.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс Блокнот
 *
 * @author faciorys
 */
public class Notebook {
    private static String catalog = "C:\\Users\\Alex\\IdeaProjects\\java-traning\\Do_and_learn\\src\\task06\\epam\\task2\\notebook\\notebook.txt";
    private List<Notebook> notebookList;
    private String topic;
    private String date;
    private String email;
    private String message;

    public String getTopic() {
        return topic;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public List<Notebook> getNotebookList() {
        return notebookList;
    }

    public Notebook(String topic, String date, String email, String message) {
        this.topic = topic;
        this.date = date;
        this.email = email;
        this.message = message;
    }

    public Notebook() {
        notebookList = new ArrayList<>();
        informationNotebook();
    }

    private void informationNotebook() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(catalog))) {
            while (reader.ready()) {
                count++;
                if (count == 5) {
                    String t = reader.readLine();
                    count = 0;
                }
                if (count == 1) {
                    topic = reader.readLine();
                } else if (count == 2) {
                    date = reader.readLine();
                } else if (count == 3) {
                    email = reader.readLine();
                } else if (count == 4) {
                    message = reader.readLine();
                    notebookList.add(new Notebook(topic, date, email, message));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Метод показать все заметки в блокноте
     */
    public void showAllNotes() {
        notebookList.forEach(System.out::println);
    }

    /*
     * Сортировка по Теме заметки
     */
    public void sortTopic() throws IOException {
        notebookList.sort(new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                return o1.getTopic().compareTo(o2.getTopic());
            }
        });
        sort();
    }

    /*
     * Сортировка по Дате заметки
     */
    public void sortDate() throws IOException {
        notebookList.sort(new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        sort();
    }

    /*
     * Сортировка по Email заметки
     */
    public void sortEmail() throws IOException {
        notebookList.sort(new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });
        sort();
    }

    /*
     * Сортировка по Сообщению заметки
     */
    public void sortMessage() throws IOException {
        notebookList.sort(new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                return o1.getMessage().compareTo(o2.getMessage());
            }
        });
        sort();
    }


    private void sort() throws IOException {
        File file = new File(catalog);
        try (FileOutputStream fos = new FileOutputStream(file, false);
             PrintWriter writer = new PrintWriter(fos)) {
            for (int i = 0; i < notebookList.size(); i++) {
                writer.print(notebookList.get(i).topic + "\n");
                writer.print(notebookList.get(i).date + "\n");
                writer.print(notebookList.get(i).email + "\n");
                writer.print(notebookList.get(i).message + "\n");
                writer.print(User.DELIMITER + "\n");
                writer.flush();
            }
        }
    }


    @Override
    public String toString() {
        return "Notebook{" +
                "topic='" + topic + '\'' +
                ", date='" + date + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
