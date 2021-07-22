/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
package view;

import controller.Manager;
import controller.Validation;

/**
 *
 * @author vanhv
 */
public class View {
    
    private final Validation v ;
    private final Manager manager;
    
    public View(){
        v = new Validation();
        manager = new Manager();
        manager.loadData();
        mainMenu();
    }
    private void mainMenu() {
        while (true) {
            System.out.println("=======Studen Management=======");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update / Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("===============================\n");
            
            int choice = v.getInt("Choose a option :", "Please input into [1, 5] :", 1, 5);
            
            switch (choice) {
                case 1: {
                    System.out.println("------Create------");
                    manager.createStudentLoop();
                    break;
                }
                case 2: {
                    System.out.println("------Find and Sort------");
                    manager.findAndSort();
                    break;
                }
                case 3: {
                    System.out.println("------Update / Delete------");
                    manager.updateAndDelete();
                    break;
                }
                case 4: {
                    System.out.println("------Report------");
                    manager.reportStudent();
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
