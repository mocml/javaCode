/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
package controller;

import entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class Manager {

    private final String[] Course = {"", "Java", ".Net", "C/C++"};

    public final ArrayList<Student> studentList = new ArrayList<>();
    private final ArrayList<Report> listReport = new ArrayList<>();

    private final Scanner sc = new Scanner(System.in);
    private final Validation v = new Validation();

    public void createStudentLoop() {
        int count = 1;
        while (count <= 3) {
            createStudent();
            count++;
        }
        while (true) {
            String cf = v.getString("Do you want to continue (Y/N)?", "Enter Y or N !", "[yYnN]");
            if (cf.equalsIgnoreCase("y")) {
                createStudent();
            } else {
                break;
            }
        }
    }

    public void findAndSort() {
        if (studentList.isEmpty()) {
            System.err.println("Student is empty please choose other !");
        } else {
            sortStudent();
            findStudent();
        }
    }

    public void updateAndDelete() {
        if (studentList.isEmpty()) {
            System.err.println("Student is empty please choose other !");
        } else {
            String id = v.getString("ID : ", "Please enter character!", "[a-zA-Z0-9]+");
            if (!checkExistID(id)) {
                System.out.println("Student found with ID [" + id + "] :");
//Display found list            
                studentFountbyId(id);
//limit input select by length of found student list
                int index = v.getInt("Select one student : ", "Select one into [1-" + getStudentbyID(id).size() + "]", 1, getStudentbyID(id).size());
//Get student of main list at index
                int getIndex = getStudentbyID(id).indexOf(getStudentbyID(id).get(index - 1));
//Select student at getIndex
                Student selected = getStudentAtIndex(getIndex);
//Check exist course in semester of student
                if (!checkExistCourse(selected)) {
                    String choose = v.getString("Do you want to update (U) or delete (D) student : ", "Semester into [1-9] : ", "[uUdD]{1,2}");
                    if (choose.equalsIgnoreCase("u")) {
                        updateStudent(id, getIndexOfStudent(selected));
                    } else {
                        deleteStudent(getIndexOfStudent(selected));
                    }
                } else {
                    System.err.println("Not exist student to update !!");
                }
            } else {
                System.err.println("Not exist student to update !!");
            }
        }
    }

    private void studentFountbyId(String id) {
        ArrayList<Student> studentFound = getStudentbyID(id);
        for (int i = 0; i < studentFound.size(); i++) {
            System.out.println("[" + (i + 1) + "]  " + studentFound.get(i));
        }
    }

    public void createStudent() {

        String id = v.getString("ID : ", "Please enter character!", "[a-zA-Z0-9]+");
        String name = v.getNameAfterConvert("Name : ", "Please enter character!", "[a-zA-Z ]+");
        int semester = v.getInt("Semester : ", "Semester into [1-9] : ", 1, 9);
        int courseIndex = v.getInt("Course (Java, .Net, C/C++) : ", "Course into [1-3] : ", 1, 3);

        Student student = new Student(id, name, semester, Course[courseIndex]);

        if (checkExistCourse(student)) {
            studentList.add(student);
            System.err.println("Add Success !\n");
        } else {
            System.out.println("Exist course in this semester !! Choose another pls.");
        }
    }

    public void reportStudent() {
        for (int i = 1; i < Course.length; i++) {
            for (Student s : studentList) {
                if (Course[i].equals(s.getCourse())) {
                    int count = totalCourse(s.getId(), Course[i]);
                    Report rp = new Report(s.getId(), s.getName(), s.getCourse(), count);
                    if (checkExistReport(s.getId(), s.getCourse())) {
                        listReport.add(rp);
                    }
                }
            }
        }
        displayReport();
        System.out.println("\n");
    }

    private void findStudent() {
        System.out.print("Enter text to find : ");
        String txtFind = sc.nextLine();
        System.out.println("ID    Name                  Semester       Course");
        int flag = 0;
        for (Student s : studentList) {
            s.setName(v.capitalizeName(s.getName()));
            if (s.getName().toLowerCase().contains(txtFind.toLowerCase())) {
                System.out.println(s);
                flag++;
            }
        }
        if (flag == 0) {
            displayStudent();
        }
        System.out.println("\n");
    }

    private void sortStudent() {
        Collections.sort(studentList, (Student o1, Student o2) -> {
            return reverseName(o1.getName()).
                    compareToIgnoreCase(reverseName(o2.getName()));
        });
    }

    private String reverseName(String name) {
        String[] words = name.split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    private void updateStudent(String id, int index) {
        System.out.println("------Update------");
        while (true) {
            String name = v.getNameAfterConvert("Name : ", "Please enter character!", "[a-zA-Z ]+");
            int semester = v.getInt("Semester : ", "Semester into [1-9] : ", 1, 9);
            int courseIndex = v.getInt("Course (Java, .Net, C/C++) : ", "Course into [1-3] : ", 1, 3);

            Student std = new Student(id, name, semester, Course[courseIndex]);

            if (checkExistCourse(std)) {
                studentList.get(index).setName(name);
                studentList.get(index).setSemester(semester);
                studentList.get(index).setCourse(Course[courseIndex]);
                System.err.println("Update Success !!\n");
                break;
            } else {
                System.out.println("Exist course in this semester !! Choose another pls.");
            }
        }
    }

    //Delete student at index
    private void deleteStudent(int index) {
        System.out.println("------Delete------");
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student itrS = itr.next();
            if (itrS.equals(studentList.get(index))) {
                itr.remove();
                break;
            }
        }
        System.err.println("Deleted !\n");
    }

    private int getIndexOfStudent(Student std) {
        return studentList.indexOf(std);
    }

    private Student getStudentAtIndex(int index) {
        return studentList.get(index);
    }

    private boolean checkExistCourse(Student student) {
        for (Student s : studentList) {
            if (s.getId().equals(student.getId())) {
                if (s.getSemester() == student.getSemester()
                        && s.getCourse().equals(student.getCourse())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkExistReport(String id, String course) {
        for (Report r : listReport) {
            if (r.getId().equals(id) && r.getCourse().equals(course)) {
                return false;
            }
        }
        return true;
    }

    //reverse name of student to sort
    private ArrayList<Student> getStudentbyID(String id) {
        ArrayList<Student> studentFound = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                studentFound.add(s);
            }
        }
        return studentFound;
    }

    private int totalCourse(String id, String course) {
        int count = 0;
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id) && s.getCourse().equalsIgnoreCase(course)) {
                count++;
            }
        }
        return count;
    }

    private void displayReport() {
        for (Report r : listReport) {
            System.out.println(r);
        }
    }

    private void displayStudent() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public void loadData() {
        studentList.add(new Student("s1", "Trí Quân Anh", 1, "Java"));
        studentList.add(new Student("s1", "Trí Quân Anh", 2, "Java"));
        studentList.add(new Student("s1", "Trí Quân Anh", 4, "Java"));
        studentList.add(new Student("s1", "Trí Quân Anh", 1, ".Net"));
        studentList.add(new Student("s1", "Trí Quân Anh", 1, "C/C++"));
        studentList.add(new Student("s2", "An Bảo Dũng", 2, "Java"));
        studentList.add(new Student("s3", "Quang Văn Vinh", 1, ".Net"));
        studentList.add(new Student("s4", "Phúc Nguyên Ngải", 1, "C/C++"));

    }

    private boolean checkExistID(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    private String getNameExistID(String id) {
        String name = null;
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                name = s.getName();
            }
        }
        return name;
    }

}
