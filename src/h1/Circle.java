package h1;

public class Circle extends Shape {

    int radius;

    @Override
    double getArea() {
        return radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
