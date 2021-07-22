/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.util.ArrayList;
import static sun.nio.ch.IOStatus.check;

/**
 *
 * @author Duc Anh
 */
public class Manager {

    ArrayList<Task> list = new ArrayList<Task>();        // id; RequirementName; TaskTypeId; date; PlanFrom , PlanTo; Assignee, Reviewer;
    Validation validator = new Validation();
    static final int NOT_EXIST = -1;

    public Manager() {
        list.add(new Task(1, "Anh", 1, "1-3-1999", 8, 17, "yo", "hey"));
        list.add(new Task(2, "Duc", 3, "21-12-2005", 9, 13, "yo", "hey"));
        list.add(new Task(3, "Trinh", 2, "2-7-2009", 10, 16, "yo", "hey"));
        list.add(new Task(4, "Hilaryous", 4, "8-6-2015", 9, 14, "yo", "hey"));
    }

    void addTask() {

        try {
            int id = 1;
            if (!list.isEmpty()) {
                id = list.get(list.size() - 1).getId() + 1;
            }
            String RequirementName = validator.getString("Requirement Name: ", "Please input character only!", "[a-zA-Z ]+");
            int taskType = validator.getInt("Task Type: ", "Enter digts [1-4] only!", 1, 4);
            String date = validator.getDate("Date: ", "Date is not exist!");

            double PlanFrom = validator.getFrom();
            double PlanTo = validator.getTo(PlanFrom);

            String Assignee = validator.getString("Assignee: ", "Please input character only!", "[a-zA-Z ]+");
            String Reviewer = validator.getString("Reviewer: ", "Please input character only!", "[a-zA-Z ]+");
            list.add(new Task(id, RequirementName, taskType, date, PlanFrom, PlanTo, Assignee, Reviewer));

            System.out.println("Add successfuly!");
        } catch (Exception e) {
            
        }
    }

    void deleteTask() {
        int id = 0;
        id = validator.getInt("Input ID: ", "Enter digits only!", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int check = index(id);
        if (check != NOT_EXIST) {
            list.remove(check);
            System.out.println("Delete successfully!");
        } else {
            System.out.println("ID is not exist!");
        }
    }

    void displayTask() {
        System.out.println("------------------------Task----------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task item : list) {
            System.out.println(item);
        }
    }

    private int index(int id) {
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            if (task.getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
