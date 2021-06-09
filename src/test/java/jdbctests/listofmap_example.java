package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class listofmap_example {
    String dbUrl = "jdbc:oracle:thin:@3.80.189.73:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void MetaDataExample() throws SQLException {
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from regions");

        //get the resultset object metadata
        ResultSetMetaData rsMetadata = resultSet.getMetaData();




        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }


}