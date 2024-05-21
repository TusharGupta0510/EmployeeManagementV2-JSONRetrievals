package com.jdbc.Retrieve.Retrievals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
    }

    @Test
    public void testGetConnection() throws ClassNotFoundException, SQLException {
        Connection connection = databaseConnection.getConnection();
        assertNotNull(connection, "Connection should not be null");
    }

    @AfterEach
    public void tearDown() throws SQLException {
        try {
			if (databaseConnection.getConnection() != null) {
			    databaseConnection.getConnection().close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
