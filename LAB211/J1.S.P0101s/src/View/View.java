/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 15/07/2021    1.0            Vanhv   
 */
package View;

import controller.Manager;
import controller.Validate;

/**
 *
 * @author vanhv
 */
public class View {

    private final Validate validate;
    private final Manager manager;

    public View() {
        validate = new Validate();
        manager = new Manager();
        manager.loadEmployee();
        mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("========Employee Management========");
            System.out.println("1. Add Employees");
            System.out.println("2. Update Employees");
            System.out.println("3. Delete Employees");
            System.out.println("4. Search Employees");
            System.out.println("5. Sort employees by salary");
            System.out.println("6. Exit");
            System.out.println("=================================\n");

            int choice = validate.getInt("Choose a option :", "Please input into [1, 6] :", 1, 6);

            switch (choice) {
                case 1: { //ADD
                    System.out.println("---------ADD---------");
                    manager.addEmployee();
                    break;
                }
                case 2: {//UPDATE
                    System.out.println("---------UPDATE---------");
                    manager.updateEmployee();
                    break;
                }
                case 3: {//DELETE
                    System.out.println("---------DELETE---------");
                    manager.delete();
                    break;
                }
                case 4: {//SEARCH
                    System.out.println("---------SEARCH---------");
                    manager.searchEmployee();
                    break;
                }
                case 5: {
                    System.out.println("---------SORT---------");
                    manager.sortEmployee();
                    break;
                }
                default: {
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
