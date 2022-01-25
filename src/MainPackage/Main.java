package MainPackage;

/**
 * @author byomesh on 20/01/22
 * @created 20/01/2022--09:40 PM
 * @project EmployeeOnboarding
 **/

import com.employee.manage.Employee;
import com.employee.manage.EmployeeDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String[] args) throws IOException {
        System.out.println("***********************************");
        //to avoid the issues of scanner, i have used bufferereder class
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int choice;
        boolean menuFlag=true;
        //  JDBC_Connection.createConnection();//for testing

        while(menuFlag)
        {
            System.out.println("""
                    select 1 for entering emp data
                    select 2 for deleting emp data
                    select 3 for displaying emp data
                     select any other key to exit""");
            choice= Integer.parseInt(bufferedReader.readLine());

            //below is the enhanced switch case loop, the older swtch case is auto upgraded to enhanced using IntelliJ IDE.
            switch (choice) {
                case 1 -> {
                    //taking the entry of details from user
                    System.out.println("enter first name, last name, dob(yyyy--mm--dd), email, phoneNumber");
                    String firstName = bufferedReader.readLine();
                    String lastName = bufferedReader.readLine();
                    String DOB = bufferedReader.readLine();
                    String email = bufferedReader.readLine();
                    long PhoneNumber = Long.parseLong(bufferedReader.readLine());
                    //making employee object of employee class
                    Employee employee = new Employee(firstName, lastName, DOB, email, PhoneNumber);
                    //sending the employee object as input data to the insertion method
                    // where first the connection is bering made using the jdbc_connection class
                    //and then the connection uses a prepared statement query type to insert data into database

                    //below boolean variable is used to check if the execution of query is successfully or not
                    boolean queryExecutionStatus = EmployeeDao.insertData(employee);
                    if (queryExecutionStatus) {
                        System.out.println("employee details added successfully");
                    } else {
                        //note that i have used system.err.println just to print the contents in errored or red color format
                        System.err.println("something went wrong");
                    }
                }
                case 2 -> {
                    System.out.println("enter employeeid to delete");
                    int empId = Integer.parseInt(bufferedReader.readLine());
                    boolean queryExecutionStatus = EmployeeDao.deleteUser(empId);
                    if (queryExecutionStatus) {
                        System.out.println("employee details deleted successfully");
                    } else {
                        //note that i have used system.err.println just to print the contents in errored or red color format
                        System.err.println("something went wrong");
                    }

                }
                case 3 ->{
                    System.out.println("Show all employees");
                    EmployeeDao.showDetails();
                }
                default -> {
                    System.out.println("exit done");
                    menuFlag = false;
                }
            }
        }

    bufferedReader.close();//CLOSING THE BUFFERED READER
    }
}
