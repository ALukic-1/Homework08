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
        return "Circle with radius: "+radius + " and Area: " + getArea();
    }
}
