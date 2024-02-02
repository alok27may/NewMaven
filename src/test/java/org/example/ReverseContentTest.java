package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReverseContentTest {

    private ReverseContent reverseContent;

    @BeforeEach
    void setUp() {
        reverseContent = new ReverseContent();
    }


    @Test
    void shouldReturnNullIfInputIsNull() {
        String output = reverseContent.reverseContent(null);
        Assertions.assertNull(output);
    }


    @Test
    void shouldReturnNullIfInputIsEmpty() {
        String output = reverseContent.reverseContent("");
        Assertions.assertNull(output);
    }


    @Test
    public void shouldReverseFile() {
        String inputFileName = "input.txt";

        String outputFileName = reverseContent.reverseContent(inputFileName);

        String expected = getFileContent(inputFileName).reverse().toString();
        String actual = getFileContent(outputFileName).toString();

        Assertions.assertNotNull(outputFileName);
        Assertions.assertEquals(expected, actual);
    }


    @Test()
    void shouldThrowExceptionIfInputFileNotFound() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            reverseContent.reverseContent("test.txt");
        });
    }


    private StringBuilder getFileContent(String fileName)  {
        StringBuilder builder=new StringBuilder();
        BufferedReader bufferedReader;
        try (FileReader fileReader = new FileReader(fileName)) {
            bufferedReader = new BufferedReader(fileReader);

            String data;
            while ((data = bufferedReader.readLine()) != null) builder.append(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder;
    }
}