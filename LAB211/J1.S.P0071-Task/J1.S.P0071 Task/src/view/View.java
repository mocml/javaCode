package view;

import controller.Manager;
import controller.Validate;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
public class View {

    private final Validate validate;
    private final Manager manager;

    public View() {
        validate = new Validate();
        manager = new Manager();
       
        menu();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("========= Task program =========");
            System.out.println("1.	Add Task");
            System.out.println("2.	Delete task");
            System.out.println("3.	Display Task");
            System.out.println("4.	Exit");
            choice = validate.getInt("Choice: ", " Please choice must be in 1 to 4!!!", 1, 4);
            switch (choice) {
                case 1:
                    manager.addTaskManager();
                    break;
                case 2:
                    manager.deleteTaskManager();
                    break;
                case 3:
                    manager.getDataTasks();
                    break;
            }
        } while (choice != 4);
    }

}
