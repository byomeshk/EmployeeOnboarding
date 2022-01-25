package com.employee.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author byomesh on 20/01/22
 * @created 20/01/2022--9:45 PM
 * @project EmployeeOnboarding
 **/
public class JDBC_Connection {
    //making an object of connection interface
    static Connection connection;
    public  static  Connection createConnection()
    {
        try
        {
            //load the driver
            //Class.forName("com.mysql.jdbc.driver");
            String url="jdbc:mysql://localhost:3306/employee";//here employee is our database name
            String username="root";
            String password="Byomesh@2110";
            //making the connection
            connection= DriverManager.getConnection(url,username,password);//now connecting the jdbc using drivermanager class
            //System.out.println("testing successful");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        connection.close();
        System.out.println("JDBC connection has been closed successfully");
    }

}
