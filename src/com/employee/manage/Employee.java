package com.employee.manage;

/**
 * @author byomesh on 20/01/22
 * @created 20/01/2022--9:34 PM
 * @project EmployeeOnboarding
 **/


public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String DOB;//here we will be usimg yyyy-mm-dd format
    private String email;
    private long phoneNumber;//i am using long here to just ensure entering of mobile number does not truncates the original value



    public Employee() {
        super();
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee(String firstName, String lastName, String DOB, String email, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Employee(int empId, String firstName, String lastName, String DOB, String email, long phoneNumber) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", email='" + email + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
