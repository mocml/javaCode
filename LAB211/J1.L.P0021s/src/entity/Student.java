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
public class Student {

    String id;
    String name;
    int semester;
    String course;

    public Student() {
    }

    public Student(String id, int semester, String course) {
        this.id = id;
        this.semester = semester;
        this.course = course;
    }

    public Student(String id, String name, int semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %13s %20s", id, name, semester, course);
    }

}
