package com.jdbc.Retrieve.Retrievals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class JsonCreatorTest {
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() {
        mockResultSet = Mockito.mock(ResultSet.class);
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testCreateJsonFromResultSet() throws SQLException {
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("firstName")).thenReturn("John");
        when(mockResultSet.getString("lastName")).thenReturn("Doe");
        when(mockResultSet.getString("website")).thenReturn("example.com");

        JSONObject jsonObject = JsonCreator.createJsonFromResultSet(mockResultSet);

        JSONArray expectedArray = new JSONArray();
        JSONObject record = new JSONObject();
        record.put("firstName", "John");
        record.put("lastName", "Doe");
        record.put("website", "example.com");
        expectedArray.add(record);

        JSONObject expectedJsonObject = new JSONObject();
        expectedJsonObject.put("employee", expectedArray);

        assertEquals(expectedJsonObject, jsonObject);
        verify(mockResultSet, times(1)).next();
        verify(mockResultSet).getString("firstName");
        verify(mockResultSet).getString("lastName");
        verify(mockResultSet).getString("website");
    }
}
