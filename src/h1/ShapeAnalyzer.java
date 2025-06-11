package h1;

import java.util.*;

public class ShapeAnalyzer {

    static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea) {

        List<Shape> result = new ArrayList<>();
        for (Shape x : shapes) {
            if (x.getArea() >= minArea) {
                result.add(x);
            }
        }
        return result;
    }


    static Shape findShapeWithMaxArea(Collection<? extends Shape> shapes) {

        List<Shape> result = new ArrayList<>();

        double maxArea = Double.MIN_VALUE;
        Shape currentMax = null;

        for (Shape x : shapes) {
            if (x.getArea() > maxArea) {
                maxArea = x.getArea();
                currentMax = x;
            }
        }
        return currentMax;
    }


    static <T extends Shape> Map<String, List<T>> groupByType(Collection<T> shapes) {
        Map<String, List<T>> result = new HashMap<>();

        for (T x : shapes) {
            String type = x.getClass().getSimpleName();


            if (!result.containsKey(type)) {
                result.put(type, new ArrayList<>());
            }

            result.get(type).add(x);


        }
        return result;
    }
}
