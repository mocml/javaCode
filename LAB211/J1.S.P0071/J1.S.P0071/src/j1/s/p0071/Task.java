/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

/**
 *
 * @author Duc Anh
 */
public class Task {

    // TaskTypeID, Requirement Name, Date(dd-MM-yyyy), PlanFrom, PlanTo, Assignee, Reviewer;
    int id;
    String RequirementName;
    int TaskTypeId;
    String date;
    double PlanFrom;
    double PlanTo;
    String Assignee;
    String Reviewer;

    public Task() {
    }

    public Task(int id, String RequirementName, int TaskTypeId, String date, double PlanFrom, double PlanTo, String Assignee, String Reviewer) {
        this.id = id;
        this.RequirementName = RequirementName;
        this.TaskTypeId = TaskTypeId;
        this.date = date;
        this.PlanFrom = PlanFrom;
        this.PlanTo = PlanTo;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeId() {
        return TaskTypeId;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public String getDate() {
        return date;
    }

    public double getPlanFrom() {
        return PlanFrom;
    }

    public double getPlanTo() {
        return PlanTo;
    }

    public String getAssignee() {
        return Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskTypeId(int TaskTypeId) {
        this.TaskTypeId = TaskTypeId;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlanFrom(double PlanFrom) {
        this.PlanFrom = PlanFrom;
    }

    public void setPlanTo(double PlanTo) {
        this.PlanTo = PlanTo;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    String getTaskType() {

        switch (TaskTypeId) {
            case 1:
                return "code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }

    double Time() {
        return (PlanTo - PlanFrom);
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15.1f%-15s%-15s", id, RequirementName, getTaskType(), date, Time(), Assignee, Reviewer);

    }

}
