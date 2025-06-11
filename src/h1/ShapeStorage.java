package h1;

import java.util.ArrayList;
import java.util.zip.ZipEntry;

public class ShapeStorage<T extends Shape> extends ArrayList<T> {

    ArrayList<T> storedShapes = new ArrayList<T>();


    double getTotalArea() {
        double Area = 0;
        double objArea = 0;
        for (T x : storedShapes) {
            objArea = x.getArea();
            Area = Area + objArea;
        }
        return Area;
    }


    void displayAllShapes() {
        for (T x : storedShapes) {
            System.out.println(x.toString());
        }
    }


    <U extends T> void importLargeShapes(ShapeStorage<U> other, double minArea) {
        for (U x : other) {
            if (x.getArea() >= minArea) {

                storedShapes.add(x);
            }
        }

    }
}
