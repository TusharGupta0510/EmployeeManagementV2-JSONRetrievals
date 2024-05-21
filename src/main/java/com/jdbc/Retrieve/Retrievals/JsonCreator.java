package com.jdbc.Retrieve.Retrievals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JsonCreator {
    @SuppressWarnings("unchecked")
	public static JSONObject createJsonFromResultSet(ResultSet rs) throws SQLException {
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();

        while (rs.next()) {
            JSONObject record = new JSONObject();
            record.put("firstName", rs.getString("firstName"));
            record.put("lastName", rs.getString("lastName"));
            record.put("website", rs.getString("website"));
            array.add(record);
        }

        jsonObject.put("employee", array);
        return jsonObject;
    }
}
