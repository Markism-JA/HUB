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
    public static final String NULL_VALUE = "NULL";
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
        boolean isFirstLine = true;
    
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;  // Skip the header line
                    continue;
                }
                String[] data = line.split(splitBy);
                try {
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].isEmpty() || data[i] == null) {
                            data[i] = NULL_VALUE;
                        }
                    }
                    T item = mapper.apply(data);
                    if (item != null) {
                        items.add(item);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return items;
    }
    

    //CSVWriter
    public static <T> void writeToCSV(String fileName, List<T> items, CSVMapper<T> mapper) {
        String header = getHeader(items.get(0).getClass());
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(header + "\n"); // Write header
    
            for (T item : items) {
                String dataString = mapper.apply(item);
                dataString = dataString.replaceAll(NULL_VALUE, ""); // Remove NULL_VALUE from non-null fields (optional)
                writer.write(dataString + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
                                                                                                                                   
}
