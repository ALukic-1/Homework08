package h1;

public class Circle extends Shape {

    double radius;

    public Circle (double radius){
        this.radius = radius;
    }

    @Override
    double getArea() {
        return radius*Math.PI*radius;
    }

    @Override
    public String toString() {
        return String.format("Circle: radius=%.2f", radius);
    }
}
