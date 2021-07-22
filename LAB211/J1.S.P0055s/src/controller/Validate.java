/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 24/06/2021    1.0            Vanhv   
 */
package controller;

import entity.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class Validate {

    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Doctor> listDoctor;

    public Validate() {
        listDoctor = new ArrayList<>();
    }

    public int getChoice(int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.err.print("Please input into[" + min + ", " + max + "] : ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.print("Please input an integer number: ");
            }
        }
    }


    public String getCode() {
        while (true) {
            System.out.print("Enter Code : ");
            String code = sc.nextLine();
            if (code.isEmpty()) {
                System.err.println("Doctor code not null !!");
                continue;
            }
            return code;
        }
    }

    public String getName() {
        while (true) {
            System.out.print("Enter Name :");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("Doctor name not null !!");
                continue;
            }
            return name;
        }
    }

    public String getSpecialization() {
        while (true) {
            System.out.print("Enter Specialization : ");
            String specialization = sc.nextLine();
            if (specialization.isEmpty()) {
                System.err.println("Doctor name not null !!");
                continue;
            }
            return specialization;
        }
    }

    public int getAvailability() {
        System.out.print("Enter Availability : ");
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException ee) {
                System.err.print("Please input an integer number: ");
            }
        }
    }

    public String getTxtSearch() {
        System.out.println("Enter search : ");
        String search = sc.nextLine();
        return search;
    }

    public boolean checkDuplicateCode(String code,ArrayList<Doctor> listDoctor) {
        for (Doctor d : listDoctor) {
            if (d.getCode().equalsIgnoreCase(code)) {
                return false;
            }
        }
        return true;
    }
}
