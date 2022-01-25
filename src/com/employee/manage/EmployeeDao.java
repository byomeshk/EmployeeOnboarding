package com.employee.manage;

/**
 * @author byomesh on 20/01/22
 * @created 20/01/2022--10:05 PM
 * @project EmployeeOnboarding
 **/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {

    //making the below method static so that i do not need to create object everytime for insertion
    public static boolean insertData( Employee employee){
        boolean flag=false;//this is to return the user if the query has successfully execute or not

        //making connection with jdbc for insertion of data in databse;
        try{
            Connection connection= JDBC_Connection.createConnection();
            //sql query which is dynamic, here we will use PreparedStatement for this query
            String query="INSERT INTO EMPLOYEE.DETAILS(FIRSTNAME,LASTNAME,DOB,EMAIL,PHONENUMBER) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            //setting the values of parameters of PreparedStatement
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getDOB());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setLong(5,employee.getPhoneNumber());

            //now executing the query statement
            preparedStatement.executeUpdate();
            flag=true;
            //setting flag true only if the line above it executes successfully, else it will go in
            // catch block and flag will remain false
            connection.close();//closing the jdbc connection
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public static boolean deleteUser(int empid) {
        boolean flag=false;//this is to return the user if the query has successfully execute or not

        //making connection with jdbc for deleting user data in databsse;
        try{
            Connection connection= JDBC_Connection.createConnection();
            //sql query which is dynamic, here we will use PreparedStatement for this query
            String query="DELETE FROM EMPLOYEE.DETAILS WHERE EMPID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            //setting the values of parameters of PreparedStatement
            preparedStatement.setInt(1,empid);


            //now executing the query statement
            preparedStatement.executeUpdate();
            flag=true;
            //setting flag true only if the line above it executes successfully, else it will go in
            // catch block and flag will remain false
            connection.close();//closing the jdbc connection
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public static void showDetails() {
        //making connection with jdbc for deleting user data in databsse;
        try{
            Connection connection= JDBC_Connection.createConnection();
            //sql query which is stataic, here we will use Statement for this query
            String query="select * from employee.details;";
            Statement statement=connection.createStatement();
            //now executing the query statement
           ResultSet resultSet=statement.executeQuery(query);

           while (resultSet.next())
           {
               int empid=resultSet.getInt(1);
               String firstName=resultSet.getString(2);
               String lastName=resultSet.getString(3);
               String DOB=resultSet.getString(4);
               String email=resultSet.getString(5);
               long number= resultSet.getLong(6);


               System.out.println("emp id::"+empid);
               System.out.println("name::"+firstName+" "+lastName);
               System.out.println("dob ::"+DOB);
               System.out.println("emailid::"+email);
               System.out.println("mobile number::"+number);
               System.out.println("===============================================");

           }
           connection.close();//closing the jdbc connection
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
