/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 13/07/2021    1.0            Vanhv   
 */
package controller;

import entity.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class Manager {

    private final Validate v;
    private final Scanner sc;
    private final ArrayList<Employee> emp;

    public Manager() {
        v = new Validate();
        emp = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    private boolean checkDuplicate(String id) {
        for (Employee e : emp) {
            if (e.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public void addEmployee() {
        String id;
        while (true) {
            id = v.getString("ID : ", "Please enter character include digit!", "[a-zA-Z0-9]+");
            if (checkDuplicate(id)) {
                break;
            } else {
                System.err.println("Duplicate ID !");
            }
        }
        String firstName = v.getString("Frist Name: ", "Please enter character!", "[a-zA-Z ]+");
        String lastName = v.getString("Last Name: ", "Please enter character!", "[a-zA-Z ]+");
        String phone = v.getString("Phone: ", "Please enter digit and ten number only!", "[0-9]{10}");
        String email = v.getString("Email: ", "Please enter correct email format!", "^[a-z0-9]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
        String address = v.getString("Address: ", "Please enter correct address!", "[a-zA-Z0-9 ]+");
        String dob = v.getDate("Date Of Birth: ", "Date is not exist! ");
        String gender = v.getString("Gender (male/female): ", "In valid!", "[a-zA-Z]+");
        double salary = v.getDouble("Salary: ", "Please enter digit and positive number only");
        String egency = v.getString("Egency: ", "Enter character and digit! ", "[a-zA-Z0-9 ]+");

        emp.add(new Employee(id, firstName, lastName, phone, email, address, dob, gender, salary, egency));
        System.err.println("Add Success\n");
    }

    public void updateEmployee() {

        if (emp.isEmpty()) {
            System.err.println("Employee is empty please choose other !");
        } else {
            String id = v.getString("ID : ", "Please enter character include digit!", "[a-zA-Z0-9]+");
            if (!checkDuplicate(id)) {
                String firstName = v.getString("Frist Name: ", "Please enter character!", "[a-zA-Z]+");
                String lastName = v.getString("Last Name: ", "Please enter character!", "[a-zA-Z ]+");
                String phone = v.getString("Phone: ", "Please enter digit and ten number only!", "[0-9]{10}");
                String email = v.getString("Email: ", "Please enter correct email format!", "^[a-z0-9]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
                String address = v.getString("Address: ", "Please enter correct address!", "[a-zA-Z0-9 ]+");
                String dob = v.getDate("Date Of Birth: ", "Date is not exist! ");
                String gender = v.getString("Gender (male/female): ", "In valid!", "[a-zA-Z ]+");
                double salary = v.getDouble("Salary: ", "Please enter digit and positive number only");
                String egency = v.getString("Egency: ", "Enter character and digit! ", "[a-zA-Z0-9 ]+");
                for (Employee e : emp) {
                    if (e.getId().equalsIgnoreCase(id)) {
                        e.setFirstName(firstName);
                        e.setLastName(lastName);
                        e.setPhone(phone);
                        e.setEmail(email);
                        e.setAddress(address);
                        e.setDob(dob);
                        e.setGender(gender);
                        e.setSalary(salary);
                        e.setEgency(egency);
                    }
                }
                System.err.println("Update Success !!\n");
            } else {
                System.err.println("Not exist employee to update !!");
            }
        }
    }

    public void delete() {
        if (emp.isEmpty()) {
            System.err.println("Employee is empty please choose other !");
        } else {
            String id = v.getString("ID : ", "Please enter character include digit!", "[a-zA-Z0-9]+");
            if (!checkDuplicate(id)) {
                Iterator<Employee> itr = emp.iterator();
                while (itr.hasNext()) {
                    Employee itrEmployee = itr.next();
                    if (itrEmployee.getId().equalsIgnoreCase(id)) {
                        itr.remove();
                    }
                    System.err.println("Deleted !");
                }
            } else {
                System.err.println("Not exist employee to delete!!");
            }
        }
    }

    public void searchEmployee() {
        if (emp.isEmpty()) {
            System.err.println("Employee is empty please choose other !");
        } else {

            System.out.print("Enter text to search : ");
            String txtSearch = sc.nextLine();
            System.err.println("------RESULT------");
            System.out.format("%-7s %-10s %-13s %-13s %-10s %-10s %-13s %-10s %-10s %-10s\n", "Id", "FirstName", "LastName", "Phone", "email", "address", "DateOfBirth", "sex", "Salary", "Egency");
            if (txtSearch == null) {
                display();
            } else {
                int flag = 0;
                for (Employee e : emp) {
                    String fullName = (e.getFirstName() + " " + e.getLastName()).trim();
                    if (fullName.contains(txtSearch)) {
                        System.out.println(e);
                        flag++;
                    }
                }
                if (flag == 0) {
                    display();
                }
            }
        }
    }

    public void sortEmployee() {
        if (emp.isEmpty()) {
            System.out.println("Employee is empty please choose other !");
        } else {
            System.out.println("    1. Sort Increase by Salary");
            System.out.println("    2. Sort Decrease by Salary");
            int choice = v.getInt("Choice : ", "Must be number [1, 2] : ", 1, 2);
            if (choice == 1) {
                Collections.sort(emp, (Employee o1, Employee o2) -> (int) (o1.getSalary() - o2.getSalary()));
                display();
            } else {
                Collections.sort(emp, (Employee o1, Employee o2) -> (int) (o2.getSalary() - o1.getSalary()));
                display();
            }
        }
    }

    public void loadEmployee() {
        emp.add(new Employee("A1", "Ha", "Van", "0123456789", "ab@cd.co", "HN", "12/12/2012", "male", 999999, "NASA"));
        emp.add(new Employee("A2", "Ha", "Vannn", "0123123489", "axyz@cd.co", "HN", "12/1/2012", "male", 666666, "NASA"));
        emp.add(new Employee("A3", "Ha", "Vannnsss", "0163456789", "ABC@tf.co", "HP", "12/12/2021", "female", 777777, "FPT"));
        emp.add(new Employee("A4", "Ha", "VannnsssSSS", "0983456789", "ab@cd.co", "QN", "12/12/2001", "female", 111111, "NASA"));
    }

    private void display() {
        for (Employee e : emp) {
            System.out.println(e);
        }
    }
}
