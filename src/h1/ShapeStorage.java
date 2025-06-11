package h1;

import java.util.ArrayList;


public class ShapeStorage<T extends Shape> extends ArrayList<T> {

    //ArrayList<T> storedShapes = new ArrayList<>();


    double getTotalArea() {
        double Area = 0;
        double objArea = 0;
        for (T x : this) {
            objArea = x.getArea();
            Area = Area + objArea;
        }
        return Area;
    }


    void displayAllShapes() {
        for (T x : this) {
            System.out.println(x.toString());
        }
    }


    <U extends T> void importLargeShapes(ShapeStorage<U> other, double minArea) {
        for (U x : other) {
            if (x.getArea() >= minArea) {

                this.add(x);
            }
        }

    }
}
