/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class Validation {

    private final Scanner sc;

    public Validation() {
        this.sc = new Scanner(System.in);
    }

    public String capitalizeName(String str) {
        String[] cap = str.toLowerCase().split(" ");
        str = "";
        for (int i = 0; i < cap.length; i++) {
            str += String.valueOf(cap[i].charAt(0)).toUpperCase() + cap[i].substring(1);
            if (i < cap.length - 1) {
                str += " ";
            }
        }
        return str;
    }

    public String getString(String msg, String err, String regex) {
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

    public String getNameAfterConvert(String msg, String err, String regex) {
        while (true) {
            System.out.print(msg);
            String name = sc.nextLine().trim();
            if (name.matches(regex)) {
                return capitalizeName(name);
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
}
