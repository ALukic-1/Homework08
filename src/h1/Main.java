package h1;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
////EX.01
//        ShapeStorage <Shape > allShapes = new ShapeStorage < >();
//        ShapeStorage <Circle > smallCircles = new ShapeStorage < >();
//
//        allShapes.add(new Rectangle (2, 3)); // 6 area
//        smallCircles.add(new Circle (1)); // ~3.14 area
//        smallCircles.add(new Circle (3)); // ~28.27 area
//
//
//        System .out. println ("Display allShapes: ");
//        allShapes.displayAllShapes();
//
//// Only circles with area >= 10 will be imported
//        allShapes . importLargeShapes ( smallCircles , 10.0);
//        System .out. println (" Display allShapes after import :");
//        allShapes . displayAllShapes ();
//        System .out. printf ("\nTotal area : %.2f\n",
//                allShapes . getTotalArea ());
//

//// EX.02

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Rectangle(3.0, 4.0));
        shapes.add(new Circle(1.0));
        shapes.add(new Rectangle(5.0, 5.0));
        shapes.add(new Circle(3.5));

        System.out.println(" All Shapes :");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        // filter shapes with area >= 15
        System.out.println("\nShapes with area >= 15:");
        List<Shape> filtered = ShapeAnalyzer
                .filterByMinArea(shapes, 15);

        for (Shape shape : filtered) {
            System.out.println(shape);
        }

        // find shape with max area
        Shape maxShape = ShapeAnalyzer
                .findShapeWithMaxArea(shapes);
        System.out.println("\nShape with max area :");
        System.out.println(maxShape);


        // group by type
        Map<String, List<Shape>> grouped = ShapeAnalyzer
                .groupByType(shapes);

        // print
        System.out.println("\nGrouped by type :");
        for (Map.Entry<String, List<Shape>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Shape shape : entry.getValue()) {
                System.out.println(" " + shape);
            }


        }
    }
}