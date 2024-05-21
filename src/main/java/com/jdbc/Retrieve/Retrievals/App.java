package com.jdbc.Retrieve.Retrievals;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            // Establish database connection
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();

            // Retrieve data from the database
            ResultSet rs = DataRetrieval.retrieveData(connection);

            // Create JSON from ResultSet
            JSONObject jsonObject = JsonCreator.createJsonFromResultSet(rs);

            // Write JSON to file
            FileWriterClass fileWriter = new FileWriterClass();
            fileWriter.writeJsonToFile(jsonObject);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
