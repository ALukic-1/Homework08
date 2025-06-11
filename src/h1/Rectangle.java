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
        return String.format("Rectangle: width=%.2f, length=%.2f", width, length);
    }
}
