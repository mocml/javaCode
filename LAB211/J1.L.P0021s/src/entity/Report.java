/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
package entity;

/**
 *
 * @author vanhv
 */
public class Report {

    String id;
    String name;
    String course;
    int totalOfCouse;

    public Report(String id, String name, String course, int totalOfCouse) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalOfCouse = totalOfCouse;
    }

    public Report() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalOfCouse() {
        return totalOfCouse;
    }

    public void setTotalOfCouse(int totalOfCouse) {
        this.totalOfCouse = totalOfCouse;
    }

    @Override
    public String toString() {
        return String.format("%-7s | %10s | %10s", name, course, totalOfCouse);
    }

}
