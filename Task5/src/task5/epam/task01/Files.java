package task5.epam.task01;

import java.io.*;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Alex\\IdeaProjects\\java-traning\\Basics_of_OOP\\src\\task5\\epam\\task01\\mynewfile.txt");
        File newFile = new File("C:\\Users\\Alex\\IdeaProjects\\java-traning\\Basics_of_OOP\\src\\task5\\epam\\task01\\");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (newFile.isDirectory()) {
            System.out.println(newFile.toString() + " - dir");
        }
        if (file.isFile()) {
            System.out.println(file.toString() + " - file");
        }

        if (file.renameTo(newFile)) {
            System.out.println("файл переименован");
        } else {
            System.out.println("файл непереименован");
        }
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(scanner.nextLine() + "\n");
            writer.flush();
        }
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
        file.delete();
    }
}
