package epam.task;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task03 {

    public static void allTasks() {
//        task01() - task05() - Работа со строкой как с массивом символов
        task01();
        task02();
        task03();
        task04();
        task05();
//        task11() - task20() - Работа со строкой как с объектом типа String или StringBuilder
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
//        task21() - task22() - Работа с регулярными выражениями
        task21();
        task22();
    }

    // Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
    public static void task01() {
        String[] strings = {"camelCase", "camelCase", "camelCase"};
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("camelCase")) {
                strings[i] = "snake_case";
            }
        }
        System.out.println(Arrays.toString(strings));
    }

    // Заменить в строке все вхождения 'word' на 'letter'.
    public static void task02() {
        String strings = "camel wordCasecamelwordCasecamelCworase".replace("word", "letter");
        System.out.println(strings);
    }

    // В строке найти количество цифр
    public static void task03() {
        String s = "1f3f3fds342df2dfs32fds3423fdf2";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        System.out.println(count);
    }

    // В строке найти количество чисел
    public static void task04() {
        String s = "I have 22 monkey , 121 pencils, and 32 apples";
        String[] sar = s.split(" ");
        int count = 0;
        for (String str : sar) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                count++;
            }
        }
        System.out.println(sar.length - count);
    }

    // Удалить в строке все лишние пробелы, т.е. серии подряд идущих пробелов заменить
    // на одиночные пробелы. Крайние пробелы в строке удалить.
    public static void task05() {
        String ola = " masha sasha     alena    ".replaceAll("\\s{2,}", " ").trim();
        System.out.println(ola + "" + ola);
    }

    // Дан текст (строка). Найдите набольшее количество подряд идущих пробелов в нем.
    public static void task11() {
        String ola = " masha sasha        alena     e rr";
        String[] word = ola.split("");
        int space = 0;
        int count = 0;
        for (String s : word) {
            if (space < count) {
                space = count;
            }
            if (s.equals(" ")) {
                count++;
            } else {
                count = 0;
            }
        }
        System.out.println("Максимальное количество пробелов подряд - " + space);
    }

    // В строке вставить после каждого символа 'a' символ 'b'.
    public static void task12() {
        String ola = " masha sasha        alena     e rr";
        String res = ola.replaceAll("a", "ab");
        System.out.println(res);

    }

    //Проверить, является ли заданное слово полиндромом
    public static void task13() {
        String word = "madam";
        String[] letters = word.split("");
        int count = 0;
        for (int a = 0; a < letters.length; a++) {
            int b = letters.length - 1 - a;
            if (letters[a].equals(letters[b])) {
                count++;
            }
        }
        if (count == letters.length) {
            System.out.println("Слово " + word + " полиндром");
        }
    }

    // С помощью функции копирования и операции конкатенации составить из частей слова "информатика" слово "торт".
    public static void task14() {
        String wordOne = "информатика";
        String[] lettersOne = wordOne.split("");
        String wordTwo = "торт";
        String[] lettersTwo = wordTwo.split("");
        for (int i = 0; i < lettersTwo.length; i++) {
            for (int a = 0; a < lettersOne.length; a++) {
                if (lettersOne[a].equals(lettersTwo[i])) {
                    System.out.print(lettersOne[a]);
                    break;
                }
            }
        }
    }

    //    Подсчитать, сколько раз среди символов заданной строки встречается буква "а".
    public static void task15() {
        String wordOne = "информатика аааааа";
        String[] lettersOne = wordOne.split("");
        int count = 0;
        for (int a = 0; a < lettersOne.length; a++) {
            if (lettersOne[a].equals("а")) {
                count++;
            }
        }
        System.out.println(count);
    }

    // Из заданной строки получить новую, повторив каждый символ дважды.
    public static void task16() {
        String word = "monkey";
        StringBuilder st = new StringBuilder(word.length() * 2);
        for (int i = 0; i < word.length(); i++) {
            st.append(word.charAt(i)).append(word.charAt(i));
        }
        word = String.valueOf(st);
        System.out.println(word);
    }

    //Вводится строкаю Требуется удалить из нее повторяющие символы и все проеблы.
    public static void task17() {
        String text = "abccfd e d ef";
        int position = 1;
        char[] characters = text.toCharArray();
        for (int i = 1; i < text.length(); i++) {
            int j;
            for (j = 0; j < position; ++j) {
                if (characters[i] == characters[j]) {
                    break;
                }
            }
            if (j == position) {
                characters[position] = characters[i];
                ++position;
            } else {
                characters[position] = 0;
                ++position;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 32 - символ равен пробелу
        for (char character : characters) {
            if (character != 0 && character != 32) {
                stringBuilder.append(character);
            }
        }
        System.out.println(stringBuilder);
    }

    // Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести на экран.
    // Случай, когда самых длинных слов может быть несколько, не обрабатывать.
    public static void task18() {
        String text = "My Alena ate cheese and garlic";
        String[] letterText = text.split(" ");
        int maxLengthArray = 0;
        int maxText = 0;
        for (int i = 0; i < letterText.length; i++) {
            if (maxLengthArray < letterText[i].length()) {
                maxLengthArray = letterText[i].length();
                maxText = i;
            }
        }
        System.out.println(letterText[maxText]);
    }

    // Посчитать колисчество строчных и прописных букв в веденной строке. Учитывать только английские буквы.
    public static void task19() {
        String text = "My Alena ate cheese and garlic";
        char[] characters = text.toCharArray();
        int bigLetter = 0;
        int smallLetter = 0;
        for (Character ch : characters) {
            if (ch >= 65 && ch <= 90) {
                bigLetter++;
            }
            if (ch >= 97 && ch <= 122) {
                smallLetter++;
            }
        }
        System.out.println("Количество строчных букв " + smallLetter + "\nКоличество прописных букв " + bigLetter);
    }

    // Создать приложение, разбирающее текст и позволяющие выполнить три разных операции с текстом:
    //    1.отсортировать абзацы по количеству предложений
    //    2.отсортировать слова по длине в предложении
    //    3.отсортировать лексемы в предложении по убыванию количества вхождений заданного символа
    public static void task20() {
        String text = "My Alena ate cheese and garlic. Right now she is studying Anasteziologia. " +
                "In 30 minutes she will go to the supermarket. She bought for us potatoes, cabbage and meat. " +
                "Borsht will be for lunch. I love her very much! She is very wonderful and beautiful girl!";
        char[] characters = text.toCharArray();
        int sentence = 0;
        for (Character ch : characters) {
            if (ch == 33 || ch == 46 || ch == 63) {
                sentence++;
            }
        }
        System.out.println("Количество предложений в тексте: " + sentence);
    }

    // Создать приложение, разбирающее текст(текст храниться в строке) и позволяющее выполнять 3 разных операции
    // с текстом: 1) сортировать абзацы по количеству предложений
    // 2) отсортировать слова по длине в предложении
    // 3) отсортировать лексемы в предложении по убыванию кол-ва вхождений заданного символа
    public static void task21() {
        Scanner sc = new Scanner(System.in);
        String text = "My Alena ate cheese and garlic. Right now she is studying Anasteziologia. " +
                "In 30 minutes she will go to the supermarket. She bought for us potatoes, cabbage and meat. " +
                "\nBorsht will be for lunch. I love her very much! She is very wonderful and beautiful girl! " +
                "\nBorsht. \nDO YOU SPEAK ENGLISH?";
        System.out.println("Выберите метод операции с текстом (введите число от 1 до 3): ");
        Task03 task03 = new Task03();
        int c = sc.nextInt();
        if (c == 1) {
            System.out.println("Вы выбрали отсортировать абзацы по количеству предложений");
            System.out.println(Task03.sort_Paragraphs(text));
        } else if (c == 2) {
            System.out.println("Вы выбрали отсортировать слова по длине в каждом предложении");
            System.out.println(Task03.sort_Words(text));
        } else if (c == 3) {
            System.out.println("Вы выбрали отсортировать лексемы по убыванию количества вхождений заданного символа");
            System.out.println("Введите лексему:");
            String str = sc.next();
            System.out.println(Task03.sortLexemeWords(text, str));
        }
    }

    public static String sort_Paragraphs(String text) {
        StringBuilder resultString = new StringBuilder();
        String[] paragraph_segmentation = text.split("\n");
        List<String> sortParagraph = new ArrayList<>();
        for (String paragraph : paragraph_segmentation) {
            sortParagraph.add(paragraph);
        }
        Collections.sort(sortParagraph, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int count = 0;
        for (String s : sortParagraph) {
            count++;
            if (count == sortParagraph.size()) {
                resultString.append(s);
            } else resultString.append(s + "\n");
        }
        return resultString.toString();
    }

    public static String sort_Words(String text) {
        StringBuilder result = new StringBuilder();
        StringBuilder resultString = new StringBuilder();
        List<String> textNew = new ArrayList<>();
        char[] chars = text.toCharArray();
        for (Character ch : chars) {
            if (ch == 33 || ch == 46 || ch == 63) {
                String st = String.valueOf(resultString);
                String[] strings = st.split(" ");

                for (String s : strings) {
                    textNew.add(s);

                }
                Collections.sort(textNew, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                });
                int count = 0;
                for (String d : textNew) {
                    count++;
                    if (count == textNew.size()) {
                        result.append(d);
                    } else {
                        result.append(d + " ");
                    }
                }
                count = 0;
                result.append(ch);
                resultString = new StringBuilder();
                textNew.clear();
            } else resultString.append(ch);
        }
        return result.toString();
    }

    public static String sortLexemeWords(String text, String str) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
        String[] words = pattern.split(text);
        List<String> stWords = new ArrayList<>();
        for (String word : words) {
            if (word.contains(str)) {
                stWords.add(word + " ");
            }
        }
        Collections.sort(stWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = stWords.size() - 1; i >= 0; i--) {
            result.append(stWords.get(i));
        }
        return result.toString();
    }

    // Анализатор позволяющий последовательно возвращать содержимое узлов xml-документа и его тип
    // (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
    public static void task22() {
        String text = "<notes>\n" +
                "    <note id =\"1\">\n" +
                "        <to>Вася</to>\n" +
                "        <from>Света</from>\n" +
                "        <heading>Напоминание</heading>\n" +
                "        <body>Позвони мне завтра</body>\n" +
                "    </note>\n" +
                "    <note id =\"2\">\n" +
                "        <to>Петя</to>\n" +
                "        <from>Маша</from>\n" +
                "        <heading>Важное напоминание</heading>\n" +
                "        <body/>\n" +
                "    </note>\n" +
                "</notes>";
        String pattern = "\\<(.+)\\>([^\\<\\>]+)\\<\\/\\1\\>";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group(2));
        }
    }
}
