package entity;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
public class Task {

    private int id;
    private String taskName;
    private int type;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;
    
    // constructors 
    
    public Task() {
    }
    // constructors full declared
    public Task(int id, String taskName, int type, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.taskName = taskName;
        this.type = type;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getType() {
        switch (type) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            default:
                return "Reviewer";
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return String.format("%-5s%25s%18s%20s%15s%20s%25s", id, taskName,
                getType(), date, (to - from) , assignee, reviewer);
    }

}
