package epam.task.task11;

public class Sentence {
    private String value = "";

    public String getValue() {
        return value;
    }

    public void addValue(Word word) {
        value +=  word.getValue() + " ";
    }
}
