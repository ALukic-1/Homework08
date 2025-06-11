package h1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class ShapeFactory {


    public static Shape fromString(String input) throws Exception {


        if (input == null || input.isEmpty()) {
            throw (new IllegalArgumentException("Input is empty"));
        }


        try (Scanner scanner = new Scanner(input)) {
            scanner.useDelimiter("[:=,]\\s*");
            if (!scanner.hasNext()) {
                throw new IllegalArgumentException("Shape type required");
            }

            String type = scanner.next().trim();


            switch (type) {
                case "Circle":
                    if (!scanner.hasNext("radius")) {
                        throw new IllegalArgumentException("Radius required");
                    }
                    scanner.next();
                    if (!scanner.hasNextDouble()) {
                        throw new IllegalArgumentException(" this radius value is not allowed");
                    }
                    double radius = scanner.nextDouble();
                    if (scanner.hasNext()) {
                        throw new IllegalArgumentException("Extra input after radius not allowed");
                    }
                    return new Circle(radius);

                case "Rectangle":
                    if (!scanner.hasNext("width || length")) {
                        throw new IllegalArgumentException("Missing width and length");
                    }
                    String first = scanner.next();
                    if (!scanner.hasNextDouble()) {
                        throw new IllegalArgumentException("Rectangle needs width value");
                    }
                    double width = scanner.nextDouble();
                    if (!scanner.hasNext("width || length")) {
                        throw new IllegalArgumentException("Missing width or length. Only one has been provided");
                    }
                    String next = scanner.next();
                    if (!scanner.hasNextDouble()) {
                        throw new IllegalArgumentException("Rectangle need length value");
                    }
                    double length = scanner.nextDouble();
                    if (scanner.hasNext()) {
                        throw new IllegalArgumentException("Extra input after parameters is not allowed");
                    }
                    return new Rectangle(width, length);

                default:
                    throw new IllegalArgumentException("Shape type is unknown");
            }
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                throw e;
            }
            throw new IllegalArgumentException("Error parsing input", e);
        }


    }
}