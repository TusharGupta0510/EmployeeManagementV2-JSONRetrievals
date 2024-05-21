package com.jdbc.Retrieve.Retrievals;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class FileWriterClassTest {
    private FileWriterClass fileWriterClass;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        mockScanner = Mockito.mock(Scanner.class);
        fileWriterClass = new FileWriterClass();
        fileWriterClass.scanner = mockScanner;
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testWriteJsonToFile() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test", "value");

        // Create a temporary file
        File tempFile = File.createTempFile("test", ".json");
        String tempFilePath = tempFile.getAbsolutePath();
        tempFile.deleteOnExit();

        when(mockScanner.nextLine()).thenReturn(tempFilePath);

        fileWriterClass.writeJsonToFile(jsonObject);

        // Verify file content
        FileWriter fileWriter = new FileWriter(tempFilePath);
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.close();

        // Check if the file exists and contains the correct JSON
        verify(mockScanner).nextLine();
    }
}
