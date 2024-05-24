package main.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CSVUtil {
  //getHeader for each component class
  
    @FunctionalInterface
    public interface CSVMapper<T> {
    String apply(T t);
    }

    public static String getHeader(Class<?> clazz) {
    StringBuilder header = new StringBuilder();
    for (Field field : clazz.getDeclaredFields()) {
        header.append(field.getName()).append(",");
    }
    return header.toString().replaceAll(",$", ""); // remove trailing comma
    }

    //CSVReader
    public static <T> List<T> readFromCSV(String fileName, Function<String[], T> mapper) {
    List<T> items = new ArrayList<>();
    String line;
    String splitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        while ((line = br.readLine()) != null) {
            String[] data = line.split(splitBy);
            items.add(mapper.apply(data));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return items;
    }

    public static <T> void writeToCSV(String fileName, List<T> items, CSVMapper<T> mapper) {
        String header = getHeader(items.get(0).getClass());
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(header + "\n"); // Write header

            for (T item : items) {
                writer.write(mapper.apply(item) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
