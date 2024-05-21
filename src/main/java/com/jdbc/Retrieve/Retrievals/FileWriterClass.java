package com.jdbc.Retrieve.Retrievals;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterClass {
    private Scanner scanner = new Scanner(System.in);

    public void writeJsonToFile(JSONObject jsonObject) {
        try {
            System.out.println("Enter the location and desired filename:");
            String inFile = scanner.nextLine();
            FileWriter file = new FileWriter(inFile);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created......");
    }
}
