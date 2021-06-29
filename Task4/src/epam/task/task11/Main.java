package epam.task.task11;

public class Main {
    public static void main(String[] args) {
        Word word = new Word("animals");
        Text text = new Text(word);

        Word word1 =  new Word("hat");
        Word word2 =  new Word("coat");
        Word word3 =  new Word("snake");

        Sentence sentence = new Sentence();
        sentence.addValue(word1);
        sentence.addValue(word2);
        sentence.addValue(word3);

        text.addBase(sentence);

        System.out.println("Head " + text.getHeader());
        System.out.println("Base " + text.getBase());
    }
}
