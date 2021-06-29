package epam.task.task05;

public class Counter {
    private int min, max, current;

    public Counter(int min_, int max_, int current_) {
        min = min_;
        max = max_;
        current = current_;
        if (max < min) {
            int tmp = max;
            max = min;
            min = tmp;
        }
        if (current < min)
            current = min;
        if (current > max)
            current = max;
    }

    public Counter(int min_, int max_) {
        this(min_, max_, min_);
        current = min;
    }

    public Counter() {
        this(2, 12, 2);
    }

    // метод увеличения
    public void inc() {
        current++;
        if (current > max)
            current = min;
    }

    // метод уменьшения
    public void dec() {
        current--;
        if (current < min)
            current = max;
    }
    // метод текущего состояния
    public int value() {
        return current;
    }
}