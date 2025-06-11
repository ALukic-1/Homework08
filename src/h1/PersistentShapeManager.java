package h1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistentShapeManager {

    private static final Logger logger = Logger.getLogger(PersistentShapeManager.class.getName());

    public static void saveShapesToFile(Collection<? extends Shape> shapes, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (Shape shape : shapes) {
                writer.write(shape.toString());
                writer.newLine();
            }
            logger.info("Successfully saved " + shapes.size() + " shapes to " + filename);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to save shapes to file: " + filename, e);
            throw new RuntimeException("Failed to save shapes to file", e);
        }
    }


    public static List<Shape> loadShapesFromFile(String filename) {
        List<Shape> shapes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    Shape shape = ShapeFactory.fromString(line);
                    shapes.add(shape);
                } catch (Exception e) {
                    logger.warning("Skipping malformed shape at line " + lineNumber +
                            " in " + filename + ": " + e.getMessage());
                }
            }
            logger.info("Loaded " + shapes.size() + " valid shapes from " + filename);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File not found: " + filename, e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading file: " + filename, e);
        }

        return shapes;
    }


    public static void clearFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            // Opening in overwrite mode truncates the file
            logger.info("Cleared contents of file: " + filename);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to clear file: " + filename, e);
        }
    }

}