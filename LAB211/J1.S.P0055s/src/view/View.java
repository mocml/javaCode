/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 24/06/2021    1.0            Vanhv   
 */
package view;

import controller.Manager;
import controller.Validate;

/**
 *
 * @author vanhv
 */
public class View {

    private final Manager manager;
    private final Validate validate;

    public View() {
        manager = new Manager();
        validate = new Validate();
        mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("========Doctor Management========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.println("=================================\n");

            System.out.print("Choose a option : ");
            int choice = validate.getChoice(1, 5);

            switch (choice) {
                case 1: { //ADD
                    System.out.println("---------ADD---------");
                    manager.addDoctor();
                    break;
                }
                case 2: {//UPDATE
                    System.out.println("---------UPDATE---------");
                    manager.updateDoctor();
                    break;
                }
                case 3: {//DELETE
                    System.out.println("---------DELETE---------");
                    manager.deleteDoctor();
                    break;
                }
                case 4: {//SEARCH
                    System.out.println("---------SEARCH---------");
                    manager.searchDoctor();
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
