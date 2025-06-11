package h1;

public class Rectangle extends Shape {

    double width;
    double length;

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }


    @Override
    double getArea() {
        return width*length;
    }

    @Override
    public String toString() {
        return "Rectangle with width "+ width + " length: "+length + " and Area: "+getArea();
    }
}
