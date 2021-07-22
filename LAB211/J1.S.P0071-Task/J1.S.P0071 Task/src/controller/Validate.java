package controller;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    //import and export data
    Scanner sc = new Scanner(System.in);

    // check int 
    public int getInt(String msg, String err, int min, int max) {
        int number = 0;
        do {
            System.out.print(msg);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.err.println(err);
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid Input!!!");
            }
        } while (true);
        return number;
    }

    // check double
    public double getDouble(String msg, String err, double min, double max) {
        double number = 0;
        do {
            System.out.print(msg);
            try {
                // trim : remove space
                number = Double.parseDouble(sc.nextLine().trim());
                if (number < min || number > max) {
                    System.err.println("Out of range!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid Input!!!");
                ex.printStackTrace(System.out);
            }
        } while (true);
        return number;
    }

    // check String
    public String getString(String msg, String form) {
        String string;
        do {
            try {
                System.out.print(msg);
                string = sc.nextLine().trim();
                if (string.matches(form)) {
                    break;
                } else {
                    System.out.println("Invalid!!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        } while (true);
        return string;
    }
    // check Date

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
    //{0,1} :  appear 0 or 1 time
    // {1,}  : appear 1 or more times
    // *{0,} :  appear 0 or more times , can input or not

    public double getTimePlan(String msg, String err, double min, double max) {
        String result;
        double check = 0;
        do {
            result = getString(msg, "^[0-9]{1,2}(\\.[50][0]*)?$");
            check = Double.parseDouble(result);
            if (check < min || check > max) {
                System.out.println(err);
            }
        } while (check < min || check > max);
        return check;
    }
}
