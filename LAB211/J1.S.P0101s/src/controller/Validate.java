/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 13/07/2021    1.0            Vanhv   
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class Validate {

    private final Scanner sc;

    public Validate() {
        this.sc = new Scanner(System.in);
    }

    String getString(String msg, String err, String regex) {
        while (true) {
            System.out.print(msg);
            String line = sc.nextLine().trim();
            if (line.matches(regex)) {
                return line;
            } else {
                System.err.println(err);
            }
        }
    }

    public int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < min || num > max) {
                    System.err.println(err);
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    int getDouble(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.err.println(err);
                }
                return num;
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    String getDate(String msg, String err) {
        while (true) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                System.out.print(msg);
                format.setLenient(false);
                Date date = format.parse(sc.nextLine());
                return format.format(date);
            } catch (ParseException e) {
                System.out.println(err);
            }
        }
    }
}
