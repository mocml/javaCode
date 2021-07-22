/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 18/07/2021    1.0            Vanhv   
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanhv
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public String getDate(String msg) {
        String regex = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}";
        while (true) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);

                System.out.print(msg);
                String input = sc.nextLine();
                if (input.matches(regex)) {

                    Date date = formatter.parse(input);
                    return formatter.format(date);
                } else {
                    System.err.println("Date not exist !!");
                }
            } catch (ParseException e) {
                System.err.println("Date not exist !!");
            }
        }
    }

    public String compareDate(String first, String second) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String result = null;
        try {
            Date date1 = formatter.parse(first);
            Date date2 = formatter.parse(second);
            if (date1.before(date2)) {
                result = "Date1 before Date2";
            } else if(date1.after(date2)){
                result = "Date1 after Date2";
            }else if(date1.equals(date2)){
                result ="Date1 equals Date2";
            }
        } catch (ParseException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
