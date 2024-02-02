package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseContent {
    public String reverseContent(final String inputFile) {
        if (inputFile == null || inputFile.isEmpty()) return null;

        final String outputFile = "output.txt";

        try (FileReader fileReader = new FileReader(inputFile); FileWriter fileWriter = new FileWriter(outputFile)) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String data;
                while ((data = bufferedReader.readLine()) != null) {
                    StringBuilder builder = new StringBuilder(data);
                    fileWriter.write(builder.reverse().toString());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outputFile;
    }


}
