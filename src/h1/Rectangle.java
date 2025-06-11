package h1;

public class Rectangle extends Shape {

    int width;
    int length;

    @Override
    double getArea() {
        return width*length;
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
