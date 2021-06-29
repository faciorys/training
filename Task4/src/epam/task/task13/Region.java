package epam.task.task13;

public class Region {
    private String name;
    private double area;

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Region(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }
}
