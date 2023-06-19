package ru.devj120.lab_2_1_PropertyFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PropertyFile {
    private final Map<String, Pair> properties = new HashMap<>();
    private File file;

    public PropertyFile() {
    }

    public PropertyFile(File file) throws IOException {
        if (file == null)
            throw new IllegalArgumentException("File is null");
        loadFromFile(file);
    }

    public PropertyFile(String fileName) throws IOException {
        if (fileName == null || fileName.isBlank())
            throw new IllegalArgumentException("File name is null");
        loadFromFile(new File(fileName));
    }

    public void loadFromFile(File file) throws IOException {
        try (BufferedReader src = new BufferedReader(new FileReader(file))) {
            String line = null;
            String comment = null;
            int lineNo = 0;
            while ((line = src.readLine()) != null) {
                lineNo++;
                if (line.isBlank())
                    continue;
                if (line.charAt(0) == '#') {
                    comment = line.substring(1);
                    continue;
                }
                int p = line.indexOf('=');
                if (p == -1) throw new IllegalArgumentException("Illegal syntax in " + lineNo + " line");
                String name = line.substring(0, p);
                String value = line.substring(p + 1);
                properties.put(name, new Pair(value, comment));
                comment = null;
            }
        }
        this.file = file;
    }

    public String get(String propertyName) {
        return properties.get(propertyName).getValue();
    }

    public void set(String propertyName, String value) {
        Pair pair = properties.getOrDefault(propertyName, new Pair());
        pair.setValue(value);
        properties.put(propertyName, pair);
    }

    public void remove(String propertyName) {
        properties.remove(propertyName);
    }

    public boolean contains(String propertyName) {
        return properties.containsKey(propertyName);
    }

    public void save(File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            properties.forEach((k, v) -> {
                if (v.getCommentary() != null) writer.println("#" + v.getCommentary());
                writer.println(k + "=" + v.getValue());
            });
        }
    }

    public void save(String fileName) throws IOException {
        save(new File(fileName));

    }

    public void print() {
        properties.forEach((k, v) -> System.out.println(k + " = " + v));
//        for (Map.Entry<String, String> entry : properties.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }
    }
}
