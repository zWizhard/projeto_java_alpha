//TESTE MÉTODO SETCONNECTION
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class DatabaseManagerTest2 {

    private Connection mockConnection;

    @BeforeEach
    public void setUp() {
        mockConnection = mock(Connection.class);
    }

    @Test
    public void testSetConnection() {
       
        DatabaseManager.setConnection(mockConnection);


        Connection actualConnection = DatabaseManager.getConnection();


        assertEquals(mockConnection, actualConnection, "The connections should be the same.");
    }

    @AfterEach
    public void tearDown() {
    	
        DatabaseManager.closeConnection();
    }
}