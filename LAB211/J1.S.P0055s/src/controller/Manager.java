/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 24/06/2021    1.0            Vanhv   
 */
package controller;

import entity.Doctor;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author vanhv
 */
public class Manager {

    private final ArrayList<Doctor> listDoctor;
    private final Validate validate;

    public Manager() {
        validate = new Validate();
        listDoctor = new ArrayList<>();
    }

    public void addDoctor() {
        String code = validate.getCode();
        String name = validate.getName();
        String specialization = validate.getSpecialization();
        int avail = validate.getAvailability();

        if (validate.checkDuplicateCode(code, listDoctor)) {
            listDoctor.add(new Doctor(code, name, specialization, avail));
            System.err.println("Add Success\n");
        } else {
            System.err.println("---Duplicate doctor code !!---\n");
        }

    }

    public void updateDoctor() {
        if (listDoctor.isEmpty()) {
            System.err.println("Doctor is empty please choose a other\n\n");
        } else {

            String code = validate.getCode();
            String name = validate.getName();
            String specialization = validate.getSpecialization();
            int avail = validate.getAvailability();

            if (!validate.checkDuplicateCode(code, listDoctor)) {
                listDoctor.forEach((Doctor doctor) -> {
                    if (code.equals(doctor.getCode())) {
                        doctor.setName(name);
                        doctor.setSpecialization(specialization);
                        doctor.setAvailability(avail);
                    }
                });
                System.err.println("Update Success !!");
            } else {
                System.err.println("Not exist doctor to update !!");
            }
        }
    }

    public void deleteDoctor() {
        if (listDoctor.isEmpty()) {
            System.err.println("Doctor is empty please choose a other !\n\n");
        } else {
            String code = validate.getCode();
            if (!validate.checkDuplicateCode(code, listDoctor)) {
                //Iterator remove better than collection remove
                Iterator<Doctor> itr = listDoctor.iterator();
                while (itr.hasNext()) {
                    Doctor itrDoctor = itr.next();
                    if (itrDoctor.getCode().equalsIgnoreCase(code)) {
                        itr.remove();
                    }
                }
                System.err.println("Deleted !");
            } else {
                System.err.println("Not exist doctor to delete !!");
            }
        }
    }

    public void searchDoctor() {
        if (listDoctor.isEmpty()) {
            System.err.println("Doctor is empty please choose a other\n\n");
        } else {
            String searchTxt = validate.getTxtSearch();
            System.err.println("------------RESULT-----------");
            System.out.println("CODE\tNAME\t   SPECIALIZATION\tAVAILABILITY");
            if (searchTxt == null) {
                listDoctor.forEach((Doctor d) -> {
                    System.out.println(d);
                });
                System.out.println("\n");
            } else {
                int flag = 0;
                for (Doctor d : listDoctor) {
                    if (d.toString().contains(searchTxt)) {
                        System.out.println(d);
                        flag++;
                    }
                }
                if (flag == 0) {
                    listDoctor.forEach((Doctor d) -> {
                        System.out.println(d);
                    });
                }
            }
        }
    }
    

}
