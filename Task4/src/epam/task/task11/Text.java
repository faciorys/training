package epam.task.task11;

public class Text {
    private String header;
    private String base = "";

    public Text(Word word) {
        header = word.getValue();
    }

    public Text(Sentence sentence) {
        header = sentence.getValue();
    }

    public void addBase(Word word) {
        base += "" + word.getValue();
    }

    public void addBase(Sentence sentence) {
        base += "" + sentence.getValue();
    }

    public String getHeader() {
        return header;
    }

    public String getBase() {
        return base;
    }
}
