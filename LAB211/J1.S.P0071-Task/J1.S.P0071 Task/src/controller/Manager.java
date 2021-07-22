package controller;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
import controller.Validate;
import entity.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager {

    private final Validate validate;
    private final List<Task> list;

    public Manager() {
        validate = new Validate();
        list = new ArrayList<>();
        //loadData();
    }

    // add task in the list
    public void addTaskManager() {
        System.out.println("------------Add Task---------------");
        String taskName = validate.getString("Requirement Name: ", "[a-zA-Z 0-9]+");
        double planFrom = validate.getTimePlan("Plan From: ", "Input must be less than 17.5 and greater than 8", 8, 17);
        double planTo = validate.getTimePlan("Plan To: ", "Input must be less than 17.5 and greater than Plan From (" + (planFrom + 0.5) + " - 17.5) : ", planFrom + 0.5, 17.5);
        int taskType = validate.getInt("Task Type: ", "Type must be less than 4 and greater than 1", 1, 4);
        String date = validate.getDate("Date: ");
        String assignee = validate.getString("Assignee: ", "[a-zA-Z ]+");
        String expert = validate.getString("Reviewer: ", "[a-zA-Z ]+");

        if (list.size() < addTask(taskName, taskType, date, planFrom, planTo, assignee, expert)) {
            System.err.println("Add Success !");
        } else {
            System.err.println("Add Fail !");
        }
    }

    public void deleteTaskManager() {
        if (list.isEmpty()) {
            System.err.println("List is Empty !");
        } else {
            System.out.println("--------Delete Task--------");
            int id = validate.getInt("ID: ", "ID not Exist ", 1, Integer.MAX_VALUE);
            if (!checkExist(id)) {
                deleteTask(String.valueOf(id));
            } else {
                System.err.println("ID not Exist");
            }
        }
    }

    private boolean checkExist(int id) {
        for (Task t : list) {
            if (t.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public int addTask(String requirementName, int taskType, String date, double planFrom, double planTo, String assignee, String expert) {
        int id = getID();
        Task task = new Task(id, requirementName, taskType, date, planFrom, planTo, assignee, expert);
        list.add(task);

        return id;
    }

    private int getID() {
        if(list.isEmpty()){
            return 1;
        }
        return list.get(list.size() - 1).getId() + 1;
    }

    // delete task in the list
    public void deleteTask(String id) {
        int idNum = Integer.valueOf(id);
        Iterator<Task> itr = list.iterator();
        while (itr.hasNext()) {
            Task itrTask = itr.next();
            if (itrTask.getId() == idNum) {
                itr.remove();
            }
        }
        System.err.println("Deleted !");
    }

    // display the task on the screen
    public void getDataTasks() {
        if (list.isEmpty()) {
            System.err.println("List is Empty !");
        } else {
            System.out.println("----------------------------------------- Task ---------------------------------------");
            System.out.println("ID 	Name	Task Type	Date	Time       Assignee     	Reviewer");
            for (Task task : list) {
                System.out.println(task);
            }
        }
    }

    public void loadData() {
        list.add(new Task(1, "PR XXX", 1, "26/06/2012", 9.5, 17.5, "TT", "Lead"));
        list.add(new Task(2, "PR YYY", 2, "29/03/2017", 8, 16.5, "Dev", "Junior"));
        list.add(new Task(3, "PR ZZZ", 3, "26/10/2016", 9.5, 17, "TT", "pr"));
        list.add(new Task(4, "PR ABC", 4, "26/10/2018", 9, 16.5, "Dev", "Newbie"));
    }

}
